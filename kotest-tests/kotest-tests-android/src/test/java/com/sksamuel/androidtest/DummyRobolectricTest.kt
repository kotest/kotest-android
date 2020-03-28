package com.sksamuel.androidtest    // Must be in this package as Robolectric runner ignores io.kotest package

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.experimental.robolectric.RobolectricTest
import io.kotest.matchers.shouldBe
import kotlinx.android.synthetic.main.activity_main.*
import org.robolectric.Robolectric

@RobolectricTest
class DummyRobolectricTest : FunSpec({
    test("Hello, Robo!") {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        
        shouldThrow<AssertionError> { activity.textview.text shouldBe "Katest!" }
        activity.textview.text shouldBe "Kotest!"
    }
})