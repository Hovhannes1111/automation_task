package pages;

import org.openqa.selenium.By;

public class ProductInformationPage extends BasePage {
    private static final By PRODUCT_NAME = By.cssSelector("div[class='product-information'] h2");
    private static final By PRODUCT_CATEGORY = By.cssSelector("div[class='product-information'] p");

    public String getProductNameText() {
        return getElement(PRODUCT_NAME).getText();
    }

    public String getProductCategoryText() {
        return getElement(PRODUCT_CATEGORY).getText();
    }
}
