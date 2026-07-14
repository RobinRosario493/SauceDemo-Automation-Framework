package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    protected ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {

        // Launch Browser
        driver = DriverFactory.getDriver();

        // Create test in Extent Report
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed Successfully");

        } else if (result.getStatus() == ITestResult.FAILURE) {

            // Capture Screenshot
            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(driver, result.getName());

            test.fail(result.getThrowable());

            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SKIP) {

            test.skip("Test Skipped");
        }

        // Save report
        extent.flush();

        // Close Browser
        DriverFactory.quitDriver();
    }
}