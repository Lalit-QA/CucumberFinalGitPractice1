package stepDefination;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.GoogleHomePage;

import java.io.IOException;

public class SearchSteps2 extends TestBase {

    GoogleHomePage googleHomePage;

    @Given("user2 is on Google")
    public void user_is_on_google() throws IOException {
        driver = initializeDriver();
        googleHomePage = new GoogleHomePage(driver);
    }

    @When("user2 searches for {string}")
    public void user_searches_for(String query) {
        googleHomePage.searchFor(query);
    }

//    @Then("user2 clicks the first search result")
//    public void user_clicks_the_first_search_result() {
//        // Implement click if needed, or assert something
//         Assert.assertTrue(driver.getTitle().contains("Selenium"));
//
//    }
}

//package stepDefination;
//
//import io.cucumber.java.en.*;
//import java.io.IOException;
//
//import org.testng.Assert;
//
//import base.TestBase;
//import pageObjects.GoogleHomePage;
//
//public class SearchSteps extends TestBase {
//
//    GoogleHomePage googleHomePage;
//
//    @Given("user is on Google")
//    public void user_is_on_google() throws IOException {
//        driver = initializeDriver();
//       // googleHomePage = new GoogleHomePage(driver);
//    }
//
//    @When("user searches for {string}")
//    public void user_searches_for(String query) {
//        googleHomePage.searchFor(query);
//    }
//
//    @Then("user clicks the first search result")
//    public void user_clicks_the_first_search_result() {
//       // Assert.fail("Force failure to test screenshot");
//    }
//}
//
//////package stepDefination;
//////
//////public class SearchSteps {
//////
//////}
//////File: src/test/java/stepDefinitions/SearchSteps.java
////
////package stepDefination;
////
////import io.cucumber.java.en.Given;
////import io.cucumber.java.en.Then;
////import io.cucumber.java.en.When;
////
////import java.io.IOException;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import pageObjects.GoogleHomePage;
////import utils.TestBase;
////
////public class SearchSteps extends TestBase {
////
////    WebDriver driver;
////    GoogleHomePage googleHomePage;
////
////    @Given("user is on Google")
////    public void user_is_on_google() throws IOException {
////        driver = WebDriverManager();
////        googleHomePage = new GoogleHomePage(driver);
////    }
////
////    @When("user searches for {string}")
////    public void user_searches_for(String query) {
////        googleHomePage.searchFor(query);
////    }
////
////    @Then("user clicks the first search result")
////    public void user_clicks_the_first_search_result() {
////       // driver.findElement(By.cssSelector("h3")).click();
////        driver.close();
////    }
////}
