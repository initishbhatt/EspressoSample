package initishbhatt.com.espressosample.baseRobot

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers.not

/**
 * @author nitishbhatt
 */
@DslMarker
annotation class AssertMarker

@AssertMarker
interface Assert

open class BaseAssert : Assert {

    fun isEnabled(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(ViewMatchers.isEnabled()))
    }

    fun isDisabled(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(not(ViewMatchers.isEnabled())))
    }

    fun isDisplayed(@IdRes resId: Int) = {
        onView(ViewMatchers.withId(resId)).check(matches(ViewMatchers.isDisplayed()))
    }

    fun matchText(@IdRes resId: Int, text: String) = {
        onView(ViewMatchers.withId(resId)).check(matches(ViewMatchers.withText(text)))
    }
}