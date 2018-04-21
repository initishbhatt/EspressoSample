package initishbhatt.com.espressosample.baseRobot

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers

/**
 * @author nitishbhatt
 */
open class BaseScreen {
    fun addText(@IdRes resId: Int, text: String) = {
        Espresso.onView(ViewMatchers.withId(resId)).perform(ViewActions.clearText(), ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
    }
}