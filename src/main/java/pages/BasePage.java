package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import utils.UiUtils;
import utils.WaitUtils;
import webDriver.Driver;

import java.util.List;

public class BasePage {
    protected void clickOnElement(By locator) {
        WaitUtils.waitUntilElementToBeClickable(getElement(locator));
        getElement(locator).click();
    }

    protected void clickOnElement(By locator, int index) {
        getElements(locator).get(index).click();
    }

    protected void fillInElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    protected void fillInElement(By locator, String text, int index) {
        Driver.getDriver().findElements(locator).get(index).sendKeys(text);
    }

    protected String getAttribute(By by, String attribute) {
        return getElement(by).getAttribute(attribute);
    }

    protected void selectDropDownValueByText(By by, String text) {
        ISelect dropDown = new Select(getElement(by));
        dropDown.selectByVisibleText(text);
    }

    protected boolean isElementDisplayed(By by) {
        WaitUtils.waitForPageLoad();
        WaitUtils.waitUntilElementPresent(by);
        return Driver.getDriver().findElement(by).isDisplayed();
    }

    protected WebElement getElement(By locator) {
        WaitUtils.waitForPageLoad();
        WaitUtils.waitUntilElementPresent(locator);
        WaitUtils.waitUntilElementDisplayed(Driver.getDriver().findElement(locator));
        UiUtils.scrollToElement(Driver.getDriver().findElement(locator));
        return Driver.getDriver().findElement(locator);
    }

    protected List<WebElement> getElements(By locator) {
        WaitUtils.waitForPageLoad();
        return Driver.getDriver().findElements(locator);
    }
}
