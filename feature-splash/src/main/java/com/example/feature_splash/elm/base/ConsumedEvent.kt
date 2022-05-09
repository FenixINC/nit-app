package com.example.feature_splash.elm.base

object ConsumedEvent : Event<Nothing> {

    override fun isConsumed(scope: Any): Boolean = true

    override fun consume(scope: Any, block: (Nothing) -> Unit) = Unit

    override fun toString(): String {
        return "ConsumedEvent"
    }
}