package pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage {
    private static final By EMAIL_INPUT = By.cssSelector("input[data-qa='login-email']");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[data-qa='login-button']");

    public LogInPage fillInEmailInput(String emailValue) {
        fillInElement(EMAIL_INPUT, emailValue);
        return this;
    }

    public LogInPage fillInPasswordInput(String passwordValue) {
        fillInElement(PASSWORD_INPUT, passwordValue);
        return this;
    }

    public void clickOnLogInButton() {
        clickOnElement(LOGIN_BUTTON);
    }
}
