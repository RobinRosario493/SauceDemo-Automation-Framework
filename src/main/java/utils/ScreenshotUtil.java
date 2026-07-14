package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Absolute path
        String path = System.getProperty("user.dir")
                + File.separator
                + "screenshots"
                + File.separator
                + testName
                + "_"
                + timeStamp
                + ".png";

        File destination = new File(path);

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsolutePath();
    }
}