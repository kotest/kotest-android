package io.kotest.androidtest

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.experimental.robolectric.RobolectricExtension

object ProjectConfig : AbstractProjectConfig() {

    override fun extensions() = listOf(RobolectricExtension())
}