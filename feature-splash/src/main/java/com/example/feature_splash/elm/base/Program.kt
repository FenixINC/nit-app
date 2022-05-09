package com.example.feature_splash.elm.base

interface Program<STATE : Any, COMMAND : Cmd> {
    fun accept(msg: Msg<STATE, COMMAND>)
}

interface Msg<STATE : Any, COMMAND : Cmd> : (STATE) -> Update<STATE, COMMAND>

interface Cmd

data class Update<STATE : Any, COMMAND : Cmd>(
    val state: STATE,
    val commands: List<COMMAND> = emptyList()
)