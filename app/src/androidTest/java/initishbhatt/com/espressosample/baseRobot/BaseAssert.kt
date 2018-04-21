package initishbhatt.com.espressosample.baseRobot

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers.not

/**
 * @author nitishbhatt
 */
open class BaseAssert {
    fun performClick(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).perform(ViewActions.click())
    }

    fun isEnabled(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(ViewMatchers.isEnabled()))
    }

    fun isDisabled(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(not(ViewMatchers.isEnabled())))
    }

    fun isDisplayed(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(ViewMatchers.isDisplayed()))
    }
}