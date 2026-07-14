package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() throws InterruptedException {

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com");

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Verify successful login
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");

        System.out.println("Login Successful!");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpack();
        productsPage.addBikeLight();
        productsPage.openCart();
        Thread.sleep(5000);
    }
}