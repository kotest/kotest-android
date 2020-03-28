package io.kotest.androidtest

import androidx.test.core.app.launchActivity
import io.kotlintest.specs.StringSpec

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