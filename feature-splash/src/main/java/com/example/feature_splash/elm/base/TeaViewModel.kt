package com.example.feature_splash.elm.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

open class TeaViewModel<STATE : Any, COMMAND : Cmd>(
    initialState: STATE,
    commandHandler: (COMMAND) -> Flow<Msg<STATE, COMMAND>> = { emptyFlow() },
    logger: (() -> String) -> Unit = /*Logger*/{},
) : ViewModel(),
    CoroutinesProgramDelegate<STATE, COMMAND> {

    override val program: CoroutinesProgram<STATE, COMMAND> = coroutinesProgram(
        initialState = initialState,
        commandHandler = commandHandler,
        scope = viewModelScope,
        logger = logger,
    )
}