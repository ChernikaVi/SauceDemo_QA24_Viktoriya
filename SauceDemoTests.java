import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTests {
    public static class SauceDemo {
        private static final String URL = "https://www.saucedemo.com";
        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.get(URL);
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void registrationTest() {

            WebElement username = driver.findElement(By.cssSelector("input[name=user-name]"));
            username.clear();
            username.sendKeys("standard_user");

            WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.cssSelector("input[name=login-button]"));
            loginButton.click();

            WebElement addToCartButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
            addToCartButton.click();
            
            WebElement removeButton = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")); // проверка
            Assert.assertTrue(removeButton.isDisplayed());

            WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
            cartButton.click();

            WebElement continueShoppingButton = driver.findElement(By.cssSelector("#continue-shopping")); // проверка
            Assert.assertTrue(continueShoppingButton.isDisplayed());

            WebElement priceOfInventory = driver.findElement(By.cssSelector(".inventory_item_price")); // проверка
            Assert.assertEquals(priceOfInventory.getText(), "$29.99");

            WebElement nameOfInventory = driver.findElement(By.cssSelector(".inventory_item_name")); // проверка
            Assert.assertEquals(nameOfInventory.getText(), "Sauce Labs Backpack");
        }
    }
}
