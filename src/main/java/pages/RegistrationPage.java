package pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {
    private static final By NEW_SIGN_UP_TEXT = By.xpath("//h2[text()='New User Signup!']");
    private static final By ENTER_ACCOUNT_INFO_TEXT = By.xpath("//b[text()='Enter Account Information']");
    private static final By ACCOUNT_CREATED_TEXT = By.xpath("//b[text()='Account Created!']");
    private static final By ACCOUNT_DELETED_TEXT = By.xpath("//b[text()='Account Deleted!']");
    private static final By NAME_INPUT = By.name("name");
    private static final By EMAIL_INPUT = By.cssSelector("input[data-qa='signup-email']");
    private static final By SIGN_UP_BUTTON = By.cssSelector("button[data-qa='signup-button']");
    private static final By MR_RADIO_BUTTON = By.id("id_gender1");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By DAYS_DROP_DOWN = By.id("days");
    private static final By MONTHS_DROP_DOWN = By.id("months");
    private static final By YEARS_DROP_DOWN = By.id("years");
    private static final By NEWSLETTER_CHECKBOX = By.id("newsletter");
    private static final By SPECIAL_OFFERS_CHECKBOX = By.id("optin");
    private static final By FIRST_NAME_INPUT = By.id("first_name");
    private static final By LAST_NAME_INPUT = By.id("last_name");
    private static final By COMPANY_INPUT = By.id("company");
    private static final By ADDRESS1_INPUT = By.id("address1");
    private static final By ADDRESS2_INPUT = By.id("address2");
    private static final By COUNTRY_DROP_DOWN = By.id("country");
    private static final By STATE_INPUT = By.id("state");
    private static final By CITY_INPUT = By.id("city");
    private static final By ZIP_CODE_INPUT = By.id("zipcode");
    private static final By MOBILE_NUMBER_INPUT = By.id("mobile_number");
    private static final By CREATE_ACCOUNT_BUTTON = By.cssSelector("button[data-qa='create-account']");
    private static final By CONTINUE_BUTTON = By.cssSelector("a[data-qa='continue-button']");

    public RegistrationPage fillInNameInput(String nameValue) {
        fillInElement(NAME_INPUT, nameValue);
        return this;
    }

    public RegistrationPage fillInEmailInput(String emailValue) {
        fillInElement(EMAIL_INPUT, emailValue);
        return this;
    }

    public RegistrationPage clickOnSignUpButton() {
        clickOnElement(SIGN_UP_BUTTON);
        return this;
    }

    public RegistrationPage clickOnMrRadioButton() {
        clickOnElement(MR_RADIO_BUTTON);
        return this;
    }

    public RegistrationPage fillInPasswordInput(String passwordValue) {
        fillInElement(PASSWORD_INPUT, passwordValue);
        return this;
    }

    public RegistrationPage selectDaysDropDown(String daysValue) {
        selectDropDownValueByText(DAYS_DROP_DOWN, daysValue);
        return this;
    }

    public RegistrationPage selectMonthsDropDown(String mothsValue) {
        selectDropDownValueByText(MONTHS_DROP_DOWN, mothsValue);
        return this;
    }

    public RegistrationPage selectYearsDropDown(String yearsValue) {
        selectDropDownValueByText(YEARS_DROP_DOWN, yearsValue);
        return this;
    }

    public RegistrationPage selectNewsLetterCheckbox() {
        clickOnElement(NEWSLETTER_CHECKBOX);
        return this;
    }

    public RegistrationPage selectSpecialOffersCheckbox() {
        clickOnElement(SPECIAL_OFFERS_CHECKBOX);
        return this;
    }

    public RegistrationPage fillInFirstNameInput(String firstNameValue) {
        fillInElement(FIRST_NAME_INPUT, firstNameValue);
        return this;
    }

    public RegistrationPage fillInLastNameInput(String lastNameValue) {
        fillInElement(LAST_NAME_INPUT, lastNameValue);
        return this;
    }

    public RegistrationPage fillInCompanyInput(String companyValue) {
        fillInElement(COMPANY_INPUT, companyValue);
        return this;
    }

    public RegistrationPage fillInAddress1Input(String address1Value) {
        fillInElement(ADDRESS1_INPUT, address1Value);
        return this;
    }

    public RegistrationPage fillInAddress2Input(String address2Value) {
        fillInElement(ADDRESS2_INPUT, address2Value);
        return this;
    }

    public RegistrationPage selectCountryDropDown(String countryValue) {
        selectDropDownValueByText(COUNTRY_DROP_DOWN, countryValue);
        return this;
    }

    public RegistrationPage fillInStateInput(String stateValue) {
        fillInElement(STATE_INPUT, stateValue);
        return this;
    }

    public RegistrationPage fillInCityInput(String cityValue) {
        fillInElement(CITY_INPUT, cityValue);
        return this;
    }

    public RegistrationPage fillInZipCodeInput(String zipCodeValue) {
        fillInElement(ZIP_CODE_INPUT, zipCodeValue);
        return this;
    }

    public RegistrationPage fillInMobileNumberInput(String mobileNumberValue) {
        fillInElement(MOBILE_NUMBER_INPUT, mobileNumberValue);
        return this;
    }

    public RegistrationPage clickOnCreateAccountButton() {
        clickOnElement(CREATE_ACCOUNT_BUTTON);
        return this;
    }

    public void clickOnContinueButton() {
        clickOnElement(CONTINUE_BUTTON);
    }

    public boolean checkNewSignUpTextIsVisible() {
        return isElementDisplayed(NEW_SIGN_UP_TEXT);
    }

    public boolean checkEnterAccountInfoTextIsVisible() {
        return isElementDisplayed(ENTER_ACCOUNT_INFO_TEXT);
    }

    public boolean checkAccountCreatedTextIsVisible() {
        return isElementDisplayed(ACCOUNT_CREATED_TEXT);
    }

    public boolean checkAccountDeletedTextIsVisible() {
        return isElementDisplayed(ACCOUNT_DELETED_TEXT);
    }
}
