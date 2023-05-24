package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutOverviewTests extends BaseTest{
    @Test
    public void checkOutProductTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, ZIPCODE);

        String actualItemName = checkoutOverviewPage.getItemName();
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);

        String actualItemDescription = checkoutOverviewPage.getItemDescription();
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);

        String actualItemPrice = checkoutOverviewPage.getItemPrice();
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);

        String actualTotalPrice = checkoutOverviewPage.getTotalPrice();
        String expectedTotalPrice = "Total: $32.39";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    @Test
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, ZIPCODE);
        checkoutOverviewPage.clickCancelButton();
        productsPage.getItemDescription(testItemName);

        String actualItemDescriptionNew = productsPage.getItemDescription(testItemName);
        String expectedItemDescriptionNew = "carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescriptionNew, expectedItemDescriptionNew);
    }
}
