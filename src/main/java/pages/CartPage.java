package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private static final By ITEMS_TABLE = By.id("cart_info_table");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("a[class='btn btn-default check_out']");

    public boolean checkItemsTableIsDiplayed() {
        return isElementDisplayed(ITEMS_TABLE);
    }

    public void clickOnProceedToCheckoutButton() {
        clickOnElement(PROCEED_TO_CHECKOUT_BUTTON);
    }

    public static class CheckoutPage extends BasePage {
        private static final By DESCRIPTION_INPUT = By.name("message");
        private static final By PLACE_ORDER_BUTTON = By.cssSelector("a[class='btn btn-default check_out']");
        private static final String YOUR_DELIVERY_ADDRESS_PATH = "//ul[@id='address_delivery']//li[text()='%s']";
        private static final String YOUR_BILLING_ADDRESS_PATH = "//ul[@id='address_invoice']//li[text()='%s']";
        private static final String ITEMS_PATH = "//table[@class='table table-condensed']//tr[@id='product-%s']//a[text()='%s']";

        public boolean checkDeliveryInfoIsDisplayed(String text) {
            return isElementDisplayed(By.xpath(String.format(YOUR_DELIVERY_ADDRESS_PATH, text)));
        }

        public boolean checkBillingInfoIsDisplayed(String text) {
            return isElementDisplayed(By.xpath(String.format(YOUR_BILLING_ADDRESS_PATH, text)));
        }

        public boolean checkProductIsAdded(String productName, int index) {
            String path = String.format(ITEMS_PATH, index, productName);
            return isElementDisplayed(By.xpath(path));
        }

        public void fillInDescriptionInput(String text) {
            fillInElement(DESCRIPTION_INPUT, text);
        }

        public void clickOnPlaceOrderButton() {
            clickOnElement(PLACE_ORDER_BUTTON);
        }
    }

    public static class PaymentPage extends BasePage {
        private static final By NAME_ON_CARD_INPUT = By.name("name_on_card");
        private static final By CARD_NUMBER_INPUT = By.name("card_number");
        private static final By CVC_INPUT = By.name("cvc");
        private static final By EXPIRATION_MONTH_INPUT = By.name("expiry_month");
        private static final By EXPIRATION_YEAR_INPUT = By.name("expiry_year");
        private static final By PAY_AND_CONFIRM_ORDER_BUTTON = By.id("submit");
        private static final By ORDER_PLACED_TEXT = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");

        public PaymentPage fillInNameOnCardInput(String name) {
            fillInElement(NAME_ON_CARD_INPUT, name);
            return this;
        }

        public PaymentPage fillInCardNumberInput(String cardNumber) {
            fillInElement(CARD_NUMBER_INPUT, cardNumber);
            return this;
        }

        public PaymentPage fillInCvcnput(String cvc) {
            fillInElement(CVC_INPUT, cvc);
            return this;
        }

        public PaymentPage fillInExpriationMonthnput(String expriationMonth) {
            fillInElement(EXPIRATION_MONTH_INPUT, expriationMonth);
            return this;
        }

        public PaymentPage fillInExpriationYearnput(String expriationYear) {
            fillInElement(EXPIRATION_YEAR_INPUT, expriationYear);
            return this;
        }

        public void clickOnPayAndConfirmOrderButton() {
            clickOnElement(PAY_AND_CONFIRM_ORDER_BUTTON);
        }

        public boolean checkOrderPlacedMessageDisplayed() {
            return isElementDisplayed(ORDER_PLACED_TEXT);
        }
    }
}
