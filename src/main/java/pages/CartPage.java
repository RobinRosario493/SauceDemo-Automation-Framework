package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    private By checkoutButton = By.id("checkout");

    // Action
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}