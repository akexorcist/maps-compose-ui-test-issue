package dev.akexorcist.mapscomposeuitestissue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class MapScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verify_mapScreenComponent() {
        launchActivity<MainActivity>()
        composeTestRule.onNodeWithTag("map_screen_title").assertIsDisplayed()
        composeTestRule.onNodeWithText("This is a map").assertIsDisplayed()
        composeTestRule.onNodeWithTag("map_screen_button").assertIsDisplayed()
        composeTestRule.onNodeWithText("Click me").assertIsDisplayed()
    }
}
