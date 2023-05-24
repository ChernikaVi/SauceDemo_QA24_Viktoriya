package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemTotalPriceLocator = By.cssSelector(".summary_info_label.summary_total_label");
    private By finishButtonLocator = By.id("finish");
    private By cancelButtonLocator = By.id("cancel");

    public boolean finishButtonIsDisplayed() {
        return driver.findElement(finishButtonLocator).isDisplayed();
    }
    public String getItemName() {
        return driver.findElement(itemNameLocator).getText();
    }
    public String getItemDescription() {
        return driver.findElement(itemDescriptionLocator).getText();
    }
    public String getItemPrice() {
        return driver.findElement(itemPriceLocator).getText();
    }
    public String getTotalPrice() {
        return driver.findElement(itemTotalPriceLocator).getText();
    }
    public void clickCancelButton() {
        driver.findElement(cancelButtonLocator).click();
    }
    public void clickFinishButton() {
        driver.findElement(finishButtonLocator).click();
    }
}
