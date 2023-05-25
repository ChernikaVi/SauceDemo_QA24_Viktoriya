package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    private static final String URL = "https://www.saucedemo.com";
    protected static final String USERNAME = "standard_user";
    protected static final String PASSWORD = "secret_sauce";
    protected final static String FIRSTNAME = "Vika";
    protected final static String LASTNAME = "Zlobich";
    protected final static String ZIPCODE = "Vika123";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckOutYourInformationPage checkOutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ProductsDetailsPage productDetailsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        productDetailsPage = new ProductsDetailsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
}
