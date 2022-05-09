package com.example.feature_splash.elm.base

fun <STATE : Any, COMMAND : Cmd> STATE.asUpdate(command: COMMAND): Update<STATE, COMMAND> {
    return asUpdate(commands = listOf(command))
}

fun <STATE : Any, COMMAND : Cmd> STATE.asUpdate(commands: List<COMMAND> = emptyList()): Update<STATE, COMMAND> {
    return Update(state = this, commands = commands)
}

fun <STATE : Any, COMMAND : Cmd> List<COMMAND>.asMsg(): Msg<STATE, COMMAND> =
    RunCommandsMsg(commands = this)

fun <STATE : Any, COMMAND : Cmd> COMMAND.asMsg(): Msg<STATE, COMMAND> =
    RunCommandsMsg(commands = listOf(this))

fun Msg<*, *>.name(): String = this::class.simpleName ?: ""

fun Cmd.name(): String = this::class.simpleName ?: ""