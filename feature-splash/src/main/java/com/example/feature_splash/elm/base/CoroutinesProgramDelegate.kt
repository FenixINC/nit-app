package com.example.feature_splash.elm.base

interface CoroutinesProgramDelegate<STATE : Any, COMMAND : Cmd> {
    val program: CoroutinesProgram<STATE, COMMAND>
}

val <STATE : Any, COMMAND : Cmd> CoroutinesProgramDelegate<STATE, COMMAND>.state
    get() = program.state

fun <STATE : Any, COMMAND : Cmd> CoroutinesProgramDelegate<STATE, COMMAND>.accept(msg: Msg<STATE, COMMAND>) {
    program.accept(msg)
}