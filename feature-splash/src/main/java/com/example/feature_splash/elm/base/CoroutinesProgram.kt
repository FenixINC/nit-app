package com.example.feature_splash.elm.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface CoroutinesProgram<STATE : Any, COMMAND : Cmd> : Program<STATE, COMMAND> {
    val state: SharedFlow<STATE>
}

@OptIn(InternalCoroutinesApi::class)
internal class CoroutinesProgramImpl<STATE : Any, COMMAND : Cmd>(
    initialState: STATE,
    private val commandHandler: (COMMAND) -> Flow<Msg<STATE, COMMAND>>,
    private val scope: CoroutineScope,
    private val logger: (() -> String) -> Unit,
) : CoroutinesProgram<STATE, COMMAND> {

    private val msgRelay = Channel<Msg<STATE, COMMAND>>(capacity = Int.MAX_VALUE)

    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    override val state: SharedFlow<STATE> = _state.asSharedFlow()

    init {
        logger { "start" }
        msgRelay
            .consumeAsFlow()
            .onEach { msg ->
                logger { "Handling message $msg" }
                //update program state and return the new state and command
                var update: Update<STATE, COMMAND>? = null
                _state.update { state ->
                    msg(state)
                        .also { update = it }
                        .state
                }
                logger { "Message result $update" }

                requireNotNull(update).commands.forEach { cmd ->
                    scope.launch {
                        logger { "running command $cmd" }
                        commandHandler(cmd).collect { accept(it) }
                    }
                }
            }
            .launchIn(scope)
    }

    override fun accept(msg: Msg<STATE, COMMAND>) {
        logger { "Accepting message $msg" }
        if (!msgRelay.trySend(msg).isSuccess) {
            error("Buffer overflow")
        }
    }
}

fun <STATE : Any, COMMAND : Cmd> coroutinesProgram(
    initialState: STATE,
    commandHandler: (COMMAND) -> Flow<Msg<STATE, COMMAND>> = { emptyFlow() },
    scope: CoroutineScope,
    logger: (() -> String) -> Unit = {},
): CoroutinesProgram<STATE, COMMAND> {
    return CoroutinesProgramImpl(
        initialState = initialState,
        commandHandler = commandHandler,
        scope = scope,
        logger = logger,
    )
}