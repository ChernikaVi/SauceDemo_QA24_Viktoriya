package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.setUsernameValue(USERNAME);
        loginPage.setPasswordValue(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartLinkDisplayed());
    }
}
