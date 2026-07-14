package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtil;

public class CheckoutCompletePage {

    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessage = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");



    public boolean isOrderSuccessful() {
        return getSuccessMessage().equals("Thank you for your order!");
    }

    public void clickBackHome() {

        WaitUtil waitUtil = new WaitUtil(driver);

        waitUtil.waitForClickability(backHomeButton).click();
    }

    public String getSuccessMessage() {

    WaitUtil waitUtil = new WaitUtil(driver);

    return waitUtil
            .waitForVisibility(successMessage)
            .getText();
}
}