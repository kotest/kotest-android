package io.kotest.android.matchers.textview

import android.graphics.Color
import android.widget.TextView
import androidx.test.core.app.launchActivity
import io.kotest.androidtest.MainActivity
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.runner.junit4.FreeSpec
import kotlinx.android.synthetic.main.activity_main.*

class TextViewMatchersTests : FreeSpec() {

   init {
      "Have Text" {
         val scenario = launchActivity<MainActivity>()

         scenario.onActivity {
            assertSoftly {
               it.textview.also { tv ->
                  tv shouldHaveText "kotest"
                  tv shouldNotHaveText "a"
                  tv shouldNotHaveText ""

                  shouldThrow<AssertionError> { tv shouldHaveText "a" }
                  shouldThrow<AssertionError> { tv shouldHaveText "" }
                  shouldThrow<AssertionError> { tv shouldNotHaveText "kotest" }
               }
            }
         }
      }

      "Have Color" {
         val scenario = launchActivity<MainActivity>()

         scenario.onActivity {
            assertSoftly {
               it.textviewColored.also { tv ->
                  tv shouldHaveTextColor Color.BLACK
                  tv shouldNotHaveTextColor Color.RED
                  tv shouldHaveTextColorId android.R.color.black
                  tv shouldNotHaveTextColorId android.R.color.white


                  shouldThrow<AssertionError> { tv shouldNotHaveTextColor Color.BLACK }
                  shouldThrow<AssertionError> { tv shouldHaveTextColor Color.RED }
                  shouldThrow<AssertionError> { tv shouldNotHaveTextColorId android.R.color.black }
                  shouldThrow<AssertionError> { tv shouldHaveTextColorId android.R.color.white }
               }
            }
         }
      }

      "All Caps" {
         val scenario = launchActivity<MainActivity>()

         scenario.onActivity {
            it.textviewAllCaps.shouldBeAllCaps()
            shouldThrow<AssertionError> { it.textviewAllCaps.shouldNotBeAllCaps() }

            it.textviewAllCaps.shouldNotBeAllCaps()
            shouldThrow<AssertionError> { it.textviewAllCaps.shouldBeAllCaps() }
         }
      }

      "Alignment" {
         val scenario = launchActivity<MainActivity>()

         scenario.onActivity {
            it.textviewAlignedEnd shouldHaveTextAlignment TextView.TEXT_ALIGNMENT_TEXT_END
            it.textviewAlignedEnd shouldNotHaveTextAlignment TextView.TEXT_ALIGNMENT_CENTER
            shouldThrow<AssertionError> { it.textviewAlignedEnd shouldHaveTextAlignment TextView.TEXT_ALIGNMENT_CENTER }
            shouldThrow<AssertionError> { it.textviewAlignedEnd shouldNotHaveTextAlignment TextView.TEXT_ALIGNMENT_TEXT_END }

            it.textview.shouldNotBeAllCaps()
            shouldThrow<AssertionError> { it.textview.shouldBeAllCaps() }
         }
      }
   }
}
