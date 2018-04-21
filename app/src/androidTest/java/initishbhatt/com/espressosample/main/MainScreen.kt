package initishbhatt.com.espressosample.main

import android.support.test.espresso.ViewInteraction
import initishbhatt.com.espressosample.R
import initishbhatt.com.espressosample.baseRobot.BaseAssert
import initishbhatt.com.espressosample.baseRobot.BaseScreen

/**
 * @author nitishbhatt
 */
fun mainScreen(func: MainScreen.() -> Unit) = MainScreen().apply { func() }


class MainScreen : BaseScreen() {
    fun enterText(text: String): () -> ViewInteraction = addText(R.id.edit_text_name, text)

    fun mainAssert(func: MainAssert.() -> Unit) = MainAssert().apply { func() }

    class MainAssert : BaseAssert() {
        fun addToStoreClick(): () -> ViewInteraction = performClick(R.id.button_add)
        fun showStoreClick(): () -> ViewInteraction = performClick(R.id.button_show)
        fun checkAddToStoreButtonEnabled(): () -> ViewInteraction = isEnabled(R.id.button_add)
        fun checkShowStoreButtonEnabled(): () -> ViewInteraction = isEnabled(R.id.button_show)
        fun checkAddToStoreButtonDisabled(): () -> ViewInteraction = isDisabled(R.id.button_add)
        fun checkShowStoreButtonDisabled(): () -> ViewInteraction = isDisabled(R.id.button_show)
    }
}