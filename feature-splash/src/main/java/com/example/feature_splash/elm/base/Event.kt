package com.example.feature_splash.elm.base

sealed interface Event<out T> {

    fun isConsumed(scope: Any = Unit): Boolean

    fun consume(scope: Any = Unit, block: (T) -> Unit)
}

//fun <T> Event<T>.andOnce(content: T): Event<T> {
//    return OneTimeEvent(content = content, previousEvent = this)
//}