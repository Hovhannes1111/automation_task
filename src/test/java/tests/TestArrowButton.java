package tests;

import constants.JsCommands;
import org.testng.annotations.Test;
import utils.UiUtils;

public class TestArrowButton extends BaseTest {
    @Test
    public void testArrowButton() {
        UiUtils.executeJsCommand(JsCommands.SCROLL_BOTTOM_OF_PAGE);

        softAssert.assertTrue(homePage.checkSubscriptionTextIsDisplayed(), "Subscription text is not displayed.");

        commonActions.clickOnUpArrow();

        softAssert.assertTrue(homePage.checkSlideTextIsDisplayed(), "Slide text is not displayed.");
    }

}
