package pages;

import org.openqa.selenium.By;

public class HeaderPage extends BasePage {
    private static final String MENU_BAR_ITEM_PATH = "//a[text()=' %s']";

    private static final By HOME_LINK = getMenuItemLocator("Home");
    private static final By SIGN_UP_LOG_IN_LINK = getMenuItemLocator("Signup / Login");
    private static final By DELETE_ACCOUNT_LINK = getMenuItemLocator("Delete Account");
    private static final By PRODUCTS_LINK = getMenuItemLocator("Products");
    private static final By CART_LINK = getMenuItemLocator("Cart");

    public boolean checkHomePageLinkIsSelected() {
        return getAttribute(HOME_LINK, "style").contains("orange");
    }

    public boolean checkProductsPageLinkIsSelected() {
        return getAttribute(PRODUCTS_LINK, "style").contains("orange");
    }

    public boolean checkCartPageLinkIsSelected() {
        return getAttribute(CART_LINK, "style").contains("orange");
    }

    public void clickOnSignUpLogInLink() {
        clickOnElement(SIGN_UP_LOG_IN_LINK);
    }

    public void clickOnDeleteAccountLink() {
        clickOnElement(DELETE_ACCOUNT_LINK);
    }

    public void clickOnProductsLink() {
        clickOnElement(PRODUCTS_LINK);
    }

    public void clickOnCartLink() {
        clickOnElement(CART_LINK);
    }

    private static By getMenuItemLocator(String item) {
        return By.xpath(String.format(MENU_BAR_ITEM_PATH, item));
    }
}
