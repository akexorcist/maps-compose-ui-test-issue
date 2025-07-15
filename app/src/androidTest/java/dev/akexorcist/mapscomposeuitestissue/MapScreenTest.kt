package dev.akexorcist.mapscomposeuitestissue

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class MapScreenTest {
    private val composeTestRuleEffectContext: CoroutineContext = EmptyCoroutineContext

    @OptIn(ExperimentalTestApi::class)
    @get:Rule
    val composeTestRule: ComposeTestRule by lazy { createEmptyComposeRule(composeTestRuleEffectContext) }

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Test
    fun verify_mapScreenComponent() = runTest {
        launchActivity<MainActivity>()
        composeTestRule.onNodeWithTag("map_screen_title").assertIsDisplayed()
        composeTestRule.onNodeWithText("This is a map").assertIsDisplayed()
        composeTestRule.onNodeWithTag("map_screen_button").assertIsDisplayed()
        composeTestRule.onNodeWithText("Click me").assertIsDisplayed()
    }
}

@ExperimentalCoroutinesApi
class TestCoroutineRule(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
