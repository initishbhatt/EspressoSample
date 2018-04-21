package initishbhatt.com.espressosample.main

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import initishbhatt.com.espressosample.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author nitishbhatt
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_all_buttons_disabled_when_no_text_is_added() {
        mainScreen {
            enterText("")

            mainAssert {
                checkAddToStoreButtonDisabled()
                checkShowStoreButtonDisabled()
            }
        }
    }


    @Test
    fun test_add_to_store_button_is_enabled_when_text_is_added() {
        mainScreen {
            enterText("some text")

            mainAssert {
                checkAddToStoreButtonEnabled()
                checkShowStoreButtonDisabled()
            }
        }
    }

    @Test
    fun test_add_remove() {
        mainScreen {
            enterText("some text")

            mainAssert {
                checkAddToStoreButtonEnabled()
            }

            enterText("")
            mainAssert {
                checkAddToStoreButtonDisabled()
            }
        }
    }

    @Test
    fun test_appflow() {
        mainScreen {
            enterText("my name")
            mainAssert {
                checkAddToStoreButtonEnabled()
                checkShowStoreButtonDisabled()
            }

            addToStoreClick()

            mainAssert {
                checkShowStoreButtonEnabled()
            }

            showStoreClick()

            mainAssert {
                checkTextsAreMatching("my name")
            }

        }
    }
}