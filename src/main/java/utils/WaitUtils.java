package utils;

import constants.JsCommands;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Driver;

import java.time.Duration;
import java.util.function.Function;

@UtilityClass
public class WaitUtils {
    private final byte TIME_OUT_SECONDS = 30;

    public void waitForPageLoad() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        ExpectedCondition<Boolean> expectation = driver -> "complete".equals(jsExecutor.executeScript(JsCommands.WAIT_FOR_PAGE_TO_LOAD).toString());
        getWebDriverWait().until(expectation);
    }

    public void waitUntilElementDisplayed(final WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementDisappear(final By by) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilElementPresent(final By by) {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementToBeClickable(final WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementTextPresent(final WebElement webElement, final String text) {
        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public boolean fluentWait(final int timeOut, final int pollingTime, final Function<WebDriver, Boolean> function) {
        return fluentWait(timeOut, pollingTime, function, NoSuchElementException.class);
    }

    public boolean fluentWait(final int timeOut, final int pollingTime, final Function<WebDriver, Boolean> function, final Class<? extends Exception> exceptionClass) {
        return new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(exceptionClass)
                .until(function);
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(Driver.getDriver(), TIME_OUT_SECONDS);
    }
}
