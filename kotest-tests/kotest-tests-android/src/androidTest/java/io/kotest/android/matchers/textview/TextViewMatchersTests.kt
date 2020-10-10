package io.kotest.android.matchers.textview

import android.graphics.Color
import androidx.test.core.app.launchActivity
import io.kotest.androidtest.MainActivity
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.runner.junit4.FreeSpec
import kotlinx.android.synthetic.main.activity_main.*

class TextViewMatchersTests : FreeSpec({
   "Have Text" {
      val scenario = launchActivity<MainActivity>()

      scenario.onActivity {
         it.textview.also { tv ->
            tv shouldHaveText "Kotest!"
            tv shouldNotHaveText "a"
            tv shouldNotHaveText ""

            shouldThrow<AssertionError> { tv shouldHaveText "a" }
            shouldThrow<AssertionError> { tv shouldHaveText "" }
            shouldThrow<AssertionError> { tv shouldNotHaveText "Kotest!" }
         }
      }
   }

   "Have Color" {
      val scenario = launchActivity<MainActivity>()

      scenario.onActivity {
         val tv = it.textviewColored

         tv shouldHaveTextColor Color.BLACK
         tv shouldNotHaveTextColor Color.RED
         tv shouldHaveTextColorId android.R.color.black
         tv shouldNotHaveTextColorId android.R.color.white


         shouldThrow<AssertionError> { tv shouldHaveTextColor Color.RED }
         shouldThrow<AssertionError> { tv shouldNotHaveTextColor Color.BLACK }
         shouldThrow<AssertionError> { tv shouldNotHaveTextColorId android.R.color.black }
         shouldThrow<AssertionError> { tv shouldHaveTextColorId android.R.color.white }
      }
   }

   "All Caps" {
      val scenario = launchActivity<MainActivity>()

      scenario.onActivity {
         it.textviewAllCaps.shouldBeAllCaps()
         shouldThrow<AssertionError> { it.textviewAllCaps.shouldNotBeAllCaps() }

         it.textview.shouldNotBeAllCaps()
         shouldThrow<AssertionError> { it.textview.shouldBeAllCaps() }
      }
   }
})
