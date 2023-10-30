package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CommonActions;
import pages.HeaderPage;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyReader;
import webDriver.Driver;

public class BaseTest {

    WebDriver webDriver;
    HeaderPage headerPage;
    HomePage homePage;
    SoftAssert softAssert;
    CommonActions commonActions;
    LogInPage logInPage;

    static final String LOGGED_IN_AS_USER_TEXT = "Logged in as %s";

    @BeforeClass
    public void init() {
        headerPage = new HeaderPage();
        homePage = new HomePage();
        commonActions = new CommonActions();
        logInPage = new LogInPage();
    }

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        Driver.createDriver("chrome");
        webDriver = Driver.getDriver();
        webDriver.get(PropertyReader.readProperty("app.url"));
        webDriver.manage().window().maximize();
        headerPage.clickOnProductsLink();
        commonActions.waitUntillPopUpAppear();
        commonActions.closeAdd();
        webDriver.get(PropertyReader.readProperty("app.url"));
        Assert.assertTrue(headerPage.checkHomePageLinkIsSelected(), "Home page is not selected.");
        Assert.assertTrue(homePage.checkThatSlideIsDisplayed(), "Slide is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    void logIn() {
        logIn(PropertyReader.readProperty("login.email"), PropertyReader.readProperty("login.password"),
                "TestName");
    }

    void logIn(String email, String password, String username) {
        headerPage.clickOnSignUpLogInLink();
        logInPage.fillInEmailInput(email)
                 .fillInPasswordInput(password)
                 .clickOnLogInButton();

        Assert.assertEquals(homePage.getLogedInAsUserText(), String.format(LOGGED_IN_AS_USER_TEXT, username), String.format(LOGGED_IN_AS_USER_TEXT, username) + " is not displayed.");
    }
}
