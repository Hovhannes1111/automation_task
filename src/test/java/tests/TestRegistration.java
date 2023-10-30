package tests;

import constants.FileNames;
import models.RegisterUserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.JsonUtils;
import utils.RandomUtils;

public class TestRegistration extends BaseTest {

    private RegistrationPage registrationPage;

    private static final String EMAIL_VALUE = RandomUtils.generateEmail();
    private static final String PASSWORD_VALUE = RandomUtils.generateRandomString(12);

    @BeforeClass
    public void createObjects() {
        registrationPage = new RegistrationPage();
    }

    @Test
    public void testUserRegistration() {
        RegisterUserModel registerUserModel = JsonUtils.deserializeJson(FileNames.REGISTER_USER_TEST_DATA, RegisterUserModel.class);
        headerPage.clickOnSignUpLogInLink();
        softAssert.assertTrue(registrationPage.checkNewSignUpTextIsVisible(), "'New User Signup!' text is not displayed.");
        registrationPage.fillInNameInput(registerUserModel.getName())
                        .fillInEmailInput(EMAIL_VALUE)
                        .clickOnSignUpButton();
        softAssert.assertTrue(registrationPage.checkEnterAccountInfoTextIsVisible(), "'Enter Account Information' text is not displayed.");

        registrationPage.clickOnMrRadioButton()
                        .fillInPasswordInput(PASSWORD_VALUE)
                        .selectDaysDropDown(registerUserModel.getDays())
                        .selectMonthsDropDown(registerUserModel.getMonths())
                        .selectYearsDropDown(registerUserModel.getYears())
                        .selectNewsLetterCheckbox()
                        .selectSpecialOffersCheckbox()
                        .fillInFirstNameInput(registerUserModel.getFirstName())
                        .fillInLastNameInput(registerUserModel.getLastName())
                        .fillInCompanyInput(registerUserModel.getCompany())
                        .fillInAddress1Input(registerUserModel.getAddress1())
                        .fillInAddress2Input(registerUserModel.getAddress2())
                        .selectCountryDropDown(registerUserModel.getCountry())
                        .fillInStateInput(registerUserModel.getState())
                        .fillInCityInput(registerUserModel.getCity())
                        .fillInZipCodeInput(registerUserModel.getZipCode())
                        .fillInMobileNumberInput(registerUserModel.getMobileNumber())
                        .clickOnCreateAccountButton();
        softAssert.assertTrue(registrationPage.checkAccountCreatedTextIsVisible(), "'Account Created!' text is not displayed.");

        registrationPage.clickOnContinueButton();

        softAssert.assertEquals(homePage.getLogedInAsUserText(), String.format(LOGGED_IN_AS_USER_TEXT, registerUserModel.getName()), String.format(LOGGED_IN_AS_USER_TEXT, registerUserModel.getName()) + " is not displayed.");

        headerPage.clickOnDeleteAccountLink();

        softAssert.assertTrue(registrationPage.checkAccountDeletedTextIsVisible(), "'Account Deleted!' text is not displayed.");

        registrationPage.clickOnContinueButton();

        softAssert.assertAll();
    }
}
