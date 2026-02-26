package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    // 🔹 Allure attachment
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // 🔹 File system screenshot (old calls won't break)
    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            String safeName = scenarioName.replaceAll("[^a-zA-Z0-9_-]", "_");
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + safeName + ".png");
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}