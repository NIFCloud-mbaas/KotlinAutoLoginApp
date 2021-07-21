package mbaas.com.nifcloud.androidautologinapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import mbaas.com.nifcloud.androidautologinapp.Utils.waitFor
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.*

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginUITest {
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun init() {
        // Specify a valid string.
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("mbaas.com.nifcloud.androidautologinapp", appContext.packageName)
    }

    @Test
    fun validateLoginInBackground() {
        onView(isRoot()).perform(waitFor(800))
        onView(withId(R.id.txtMessage)).check(matches(withText("お帰りなさい！")))
        onView(withId(R.id.txtLogin)).check(matches(withText(containsString("最終ログインは："))))
    }
}