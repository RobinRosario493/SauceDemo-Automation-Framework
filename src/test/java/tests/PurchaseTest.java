package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseTest() throws InterruptedException {

        // Open website
        driver.get(ConfigReader.getUrl());
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );
        // Verify login
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        // Products
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpack();
        productsPage.addBikeLight();
        productsPage.openCart();

        // Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(ConfigReader.getFirstName());
        checkoutPage.enterLastName(ConfigReader.getLastName());
        checkoutPage.enterPostalCode(ConfigReader.getZipCode());

        checkoutPage.clickContinue();

        // Pause so we can see what page we're on
        Thread.sleep(5000);

        checkoutPage.clickFinish();

        // Order Confirmation
        CheckoutCompletePage completePage =
                new CheckoutCompletePage(driver);

        Assert.assertTrue(completePage.isOrderSuccessful());

        System.out.println("Purchase Completed Successfully!");

        // Back to Products
        completePage.clickBackHome();

        // Verify Back Home
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.google.com");

        System.out.println("Returned to Products Page Successfully!");
    }
}