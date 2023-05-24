package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsDetailsTest extends BaseTest{

    @Test
    public void openItemTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItem(testItemName);
        Assert.assertTrue(productDetailsPage.addToCartButtonIsDisplayed());
        Assert.assertTrue(productDetailsPage.backToProductsButtonIsDisplayed());
    }
}
