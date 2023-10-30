package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    private static final By SEARCH_INPUT = By.id("search_product");
    private static final By SEARCH_BUTTON = By.id("submit_search");
    private static final By VIEW_PRODUCT_BUTTONS = By.xpath("//a[text()='View Product']");
    private static final By ALL_PRODUCTS_TEXT = By.xpath("//h2[text()='All Products']");
    private static final By SEARCHED_PRODUCTS_TEXT = By.xpath("//h2[text()='Searched Products']");
    private static final By ADD_TO_PRODUCT = By.xpath("//div[@class='productinfo text-center']//a[text()='Add to cart']");
    private static final By PRODUCT_NAME_TEXT = By.cssSelector("div[class='productinfo text-center'] p");
    private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("div[id='cartModal'] button");

    public ProductsPage fillInSearchInput(String text) {
        fillInElement(SEARCH_INPUT, text);
        return this;
    }

    public void clickOnSearchButton() {
        clickOnElement(SEARCH_BUTTON);
    }

    public List<WebElement> getViewProductButtons() {
        return getElements(VIEW_PRODUCT_BUTTONS);
    }

    public void clickOnViewProduct(int index) {
        clickOnElement(VIEW_PRODUCT_BUTTONS, index);
    }

    public boolean checkAllProductsTextIsDisplayed() {
        return isElementDisplayed(ALL_PRODUCTS_TEXT);
    }

    public boolean checkSearchedProductsTextIsDisplayed() {
        return isElementDisplayed(SEARCHED_PRODUCTS_TEXT);
    }

    public void clickOnAddToProduct(int index) {
        clickOnElement(ADD_TO_PRODUCT, index);
    }

    public String getProductName(int index) {
        return getElements(PRODUCT_NAME_TEXT).get(index).getText();
    }

    public void clickOnContinueShoppingButton() {
        clickOnElement(CONTINUE_SHOPPING_BUTTON);
    }
}
