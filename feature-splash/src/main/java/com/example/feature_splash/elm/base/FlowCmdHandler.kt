package com.example.feature_splash.elm.base

import kotlinx.coroutines.flow.Flow

interface FlowCmdHandler<COMMAND : Cmd, BASE_COMMAND : Cmd, STATE : Any> {
    operator fun invoke(cmd: COMMAND): Flow<Msg<STATE, BASE_COMMAND>>
}