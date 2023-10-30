package pages;

import constants.JsCommands;
import org.openqa.selenium.By;
import utils.UiUtils;
import utils.WaitUtils;
import webDriver.Driver;

public class CommonActions extends BasePage {
    private static final By AD_PATH = By.xpath("//ins");
    private static final By POP_UP_AD_PATH = By.xpath("//ins[@class='adsbygoogle adsbygoogle-noablate' and @data-vignette-loaded='true']");
    private static final By UP_ARROW = By.id("scrollUp");

    public void closeAdd() {
        WaitUtils.waitUntilElementPresent(AD_PATH);
        Driver.getDriver().findElements(AD_PATH).forEach(element -> UiUtils.executeJsCommand(JsCommands.CLOSE_AD, element));
    }

    public void waitUntillPopUpAppear() {
        WaitUtils.waitUntilElementPresent(POP_UP_AD_PATH);
    }

    public void clickOnUpArrow() {
        clickOnElement(UP_ARROW);
    }
}
