package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.*;
import utilities.CSVUtils;

import java.io.IOException;

public class LoginStepsCSV extends TestBase {

    WebDriver driver = TestBase.driver;

    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException {
        driver = initializeDriver();
        Assert.assertTrue(driver.getTitle().length() > 0);
    }

    @When("user logs in using csv row {string}")
    public void user_logs_in_using_csv_row(String rowNum) {
        int row = Integer.parseInt(rowNum);
        String[] data = CSVUtils.getRow("LoginData.csv", row - 1); // 1-based in feature

        String username = data[0];
        String password = data[1];

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("login should be {string}")
    public void login_should_be(String expectedResult) {
        String message = driver.findElement(By.id("flash")).getText();

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(message.contains("secure area"));
        } else {
            Assert.assertTrue(message.toLowerCase().contains("invalid"));
        }
    }
}