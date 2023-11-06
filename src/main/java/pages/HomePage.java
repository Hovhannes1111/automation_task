package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By LOGGED_IN_AS_USER_TEXT = By.xpath("//i[@class='fa fa-user']/parent::a");
    private static final By SLIDE = By.id("slider-carousel");
    private static final By SUBSCRIPTION_TEXT = By.xpath("//h2[text()='Subscription']");
    private static final By SLIDE_TEXT = By.xpath("//section[@id='slider']//div[@class='item active']//h2[text()='Full-Fledged practice website for Automation Engineers']");

    public boolean checkThatSlideIsDisplayed() {
        return isElementDisplayed(SLIDE);
    }

    public String getLogedInAsUserText() {
        return getElement(LOGGED_IN_AS_USER_TEXT).getText();
    }

    public boolean checkSubscriptionTextIsDisplayed() {
        return isElementDisplayed(SUBSCRIPTION_TEXT);
    }

    public boolean checkSlideTextIsDisplayed() {
        return isElementDisplayed(SLIDE_TEXT);
    }
}
