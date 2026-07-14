package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtil;

public class CheckoutPage {

    private WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    // Actions
    public void enterFirstName(String first) {
        driver.findElement(firstName).sendKeys(first);
    }

    public void enterLastName(String last) {
        driver.findElement(lastName).sendKeys(last);
    }

    public void enterPostalCode(String zip) {
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {

         WaitUtil waitUtil = new WaitUtil(driver);

        waitUtil.waitForClickability(finishButton).click();
}

    // Complete checkout
    public void completeCheckout(String first, String last, String zip) {
        enterFirstName(first);
        enterLastName(last);
        enterPostalCode(zip);
        clickContinue();
        clickFinish();
    }
}