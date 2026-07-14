package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cart = By.className("shopping_cart_link");

    // Actions
    public void addBackpack() {
        driver.findElement(backpack).click();
    }

    public void addBikeLight() {
        driver.findElement(bikeLight).click();
    }

    public void openCart() {
        driver.findElement(cart).click();
    }
}