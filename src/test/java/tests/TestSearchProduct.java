package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductInformationPage;
import pages.ProductsPage;
import utils.UiUtils;

public class TestSearchProduct extends BaseTest {

    private ProductsPage productsPage;
    private ProductInformationPage productInformationPage;

    private static final String SEARCH_VALUE = "Jeans";

    @BeforeClass
    public void createObjects() {
        productsPage = new ProductsPage();
        productInformationPage = new ProductInformationPage();
    }

    @Test
    public void testProductSearch() {
        headerPage.clickOnProductsLink();

        softAssert.assertTrue(headerPage.checkProductsPageLinkIsSelected(), "Product page is not selected.");
        softAssert.assertTrue(productsPage.checkAllProductsTextIsDisplayed(), "'All Products' text is not displayed.");

        productsPage.fillInSearchInput(SEARCH_VALUE)
                    .clickOnSearchButton();

        softAssert.assertTrue(productsPage.checkSearchedProductsTextIsDisplayed(), "'Searched Products' text is not displayed.");

        for (int i = 0; i < productsPage.getViewProductButtons().size(); i++) {
            UiUtils.scrollToElement(productsPage.getViewProductButtons().get(i));
            productsPage.clickOnViewProduct(i);
            softAssert.assertTrue(productInformationPage.getProductCategoryText().contains(SEARCH_VALUE),
                    productInformationPage.getProductNameText() + " - product should not appear");
            UiUtils.navigateBack();
            commonActions.closeAdd();
        }

        softAssert.assertAll();
    }
}
