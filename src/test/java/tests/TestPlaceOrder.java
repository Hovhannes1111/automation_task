package tests;

import constants.FileNames;
import models.CardInfoModel;
import models.RegisterUserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import utils.JsonUtils;

import java.util.List;

import static pages.CartPage.CheckoutPage;
import static pages.CartPage.PaymentPage;

public class TestPlaceOrder extends BaseTest {

    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    private static final String DESCRIPTION_VALUE = "Description";

    @BeforeClass
    public void createObjects() {
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
    }

    @Test
    public void testPlaceOrder() {
        RegisterUserModel registerUserModel = JsonUtils.deserializeJson(FileNames.REGISTER_USER_TEST_DATA, RegisterUserModel.class);
        CardInfoModel cardInfoModel = JsonUtils.deserializeJson(FileNames.CARD_INFO_TEST_DATA, CardInfoModel.class);
        logIn();
        headerPage.clickOnProductsLink();
        commonActions.closeAdd();
        productsPage.clickOnAddToProduct(0);
        productsPage.clickOnContinueShoppingButton();
        productsPage.clickOnAddToProduct(1);
        productsPage.clickOnContinueShoppingButton();
        List<String> productNames = List.of(productsPage.getProductName(0), productsPage.getProductName(1));
        headerPage.clickOnCartLink();

        softAssert.assertTrue(headerPage.checkCartPageLinkIsSelected(), "Cart page is not selected.");
        softAssert.assertTrue(cartPage.checkItemsTableIsDiplayed(), "Items table is not selected");

        cartPage.clickOnProceedToCheckoutButton();

        String firstLastName = "Mr. " + registerUserModel.getFirstName() + " " + registerUserModel.getLastName();
        String company = registerUserModel.getCompany();
        String address1 = registerUserModel.getAddress1();
        String address2 = registerUserModel.getAddress1();
        String countryInfo = registerUserModel.getCity() + " " + registerUserModel.getCountry() + "\n" +
                "\t\t\t\t\t\t\t\t" + registerUserModel.getZipCode();
        String state = registerUserModel.getState();
        String mobile = registerUserModel.getMobileNumber();

        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(firstLastName), "First name and Last name info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(company), "Company info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(address1), "Address1 info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(address2), "Address2 info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(countryInfo), "Country info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(state), "State info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkDeliveryInfoIsDisplayed(mobile), "Mobile info is incorrect.");

        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(firstLastName), "First name and Last name info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(company), "Company info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(address1), "Address1 info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(address2), "Address2 info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(countryInfo), "Country info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(state), "State info is incorrect.");
        softAssert.assertTrue(checkoutPage.checkBillingInfoIsDisplayed(mobile), "Mobile info is incorrect.");

        softAssert.assertTrue(checkoutPage.checkProductIsAdded(productNames.get(0), 1), productNames.get(0) + " - product is not added.");
        softAssert.assertTrue(checkoutPage.checkProductIsAdded(productNames.get(1), 2), productNames.get(1) + " - product is not added.");

        checkoutPage.fillInDescriptionInput(DESCRIPTION_VALUE);
        checkoutPage.clickOnPlaceOrderButton();

        paymentPage.fillInNameOnCardInput(cardInfoModel.getNameOnCard())
                   .fillInCardNumberInput(cardInfoModel.getCardNumber())
                   .fillInCvcnput(cardInfoModel.getCvc())
                   .fillInExpriationMonthnput(cardInfoModel.getExpMonth())
                   .fillInExpriationYearnput(cardInfoModel.getExpYear())
                   .clickOnPayAndConfirmOrderButton();

        softAssert.assertTrue(paymentPage.checkOrderPlacedMessageDisplayed(), "Order confirmed message is not displayed.");
        softAssert.assertAll();
    }
}
