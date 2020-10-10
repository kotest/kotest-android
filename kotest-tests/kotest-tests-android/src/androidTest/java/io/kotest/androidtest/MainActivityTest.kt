package io.kotest.androidtest

import androidx.test.core.app.launchActivity
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityTest : StringSpec() {
    init {
        "Hello World test" {
            val scenario = launchActivity<MainActivity>()

            scenario.onActivity {
                it.textview.text shouldBe "Kotest!"
            }
        }
    }
}
