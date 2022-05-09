package com.example.feature_splash.elm.base

internal class RunCommandsMsg<STATE : Any, COMMAND : Cmd>(
    private val commands: List<COMMAND>
) : Msg<STATE, COMMAND> {

    override fun invoke(state: STATE): Update<STATE, COMMAND> {
        return state.asUpdate(commands = commands)
    }

    override fun toString(): String {
        return "RunCommandsMsg(commands=$commands)"
    }
}