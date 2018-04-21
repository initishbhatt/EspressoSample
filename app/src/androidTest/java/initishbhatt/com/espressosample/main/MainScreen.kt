package initishbhatt.com.espressosample.main

import android.support.test.espresso.ViewInteraction
import initishbhatt.com.espressosample.R
import initishbhatt.com.espressosample.baseRobot.BaseAssert
import initishbhatt.com.espressosample.baseRobot.BaseScreen

/**
 * @author nitishbhatt
 */
fun mainScreen(func: MainScreen.() -> Unit) = MainScreen().apply { func() }


class MainScreen {
    private val baseScreen: BaseScreen = BaseScreen()
    fun enterText(text: String): () -> ViewInteraction = baseScreen.addText(R.id.edit_text_name, text)
    fun addToStoreClick(): () -> ViewInteraction = baseScreen.performClick(R.id.button_add)
    fun showStoreClick(): () -> ViewInteraction = baseScreen.performClick(R.id.button_show)

    fun mainAssert(func: MainAssert.() -> Unit) = MainAssert().apply { func() }

    class MainAssert {
        private val baseAssert: BaseAssert = BaseAssert()
        fun checkAddToStoreButtonEnabled(): () -> ViewInteraction = baseAssert.isEnabled(R.id.button_add)
        fun checkShowStoreButtonEnabled(): () -> ViewInteraction = baseAssert.isEnabled(R.id.button_show)
        fun checkAddToStoreButtonDisabled(): () -> ViewInteraction = baseAssert.isDisabled(R.id.button_add)
        fun checkShowStoreButtonDisabled(): () -> ViewInteraction = baseAssert.isDisabled(R.id.button_show)
        fun checkTextsAreMatching(text: String): () -> ViewInteraction = baseAssert.matchText(R.id.text_store_value, text)
    }
}