package utils;

import constants.JsCommands;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import lombok.experimental.UtilityClass;
import webDriver.Driver;

@UtilityClass
public class UiUtils {
    public void scrollToElement(final WebElement webElement) {
        executeJsCommand(JsCommands.SCROLL_TO_VIEW_ELEMENT, webElement);
    }

    public void executeJsCommand(final String command, final WebElement webElement) {
        getJavascriptExecutor().executeScript(command, webElement);
    }

    public void executeJsCommand(final String command) {
        getJavascriptExecutor().executeScript(command);
    }

    public void acceptSimpleAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }

    public void managePromptPopUp(final String text, final boolean accept) {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(text);
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    public void manageConfirmationPopUp(final boolean accept) {
        Alert alert = Driver.getDriver().switchTo().alert();
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    public void navigateBack() {
        Driver.getDriver().navigate().back();
        WaitUtils.waitForPageLoad();
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) Driver.getDriver();
    }
}
