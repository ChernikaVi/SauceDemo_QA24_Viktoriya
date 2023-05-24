package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutYourInformationTest extends BaseTest{
    @Test
    public void positiveCheckout() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutPage.setFirstNameValue(FIRSTNAME);
        checkOutPage.setLastNameValue(LASTNAME);
        checkOutPage.setPostalCodeValue(ZIPCODE);
        checkOutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }

    @Test
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutPage.clickCancelButton();
        Assert.assertTrue(cartPage.isContinueShoppingIsDisplayed());
    }
}
