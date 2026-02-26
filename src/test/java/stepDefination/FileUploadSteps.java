//package stepDefination;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.*;
//import utils.TestBase;
//
//public class FileUploadSteps extends TestBase {
//
//    WebDriver driver;
//
//    @Given("User launches the browser and opens upload page")
//    public void launchBrowser() throws Exception {
//        driver = WebDriverManager(); // initialize driver from TestBase
//     //   driver.get("https://the-internet.herokuapp.com/upload"); // file upload page
//    }
//
//    @When("User uploads a file")
//    public void uploadFile() {
//        WebElement uploadElement = driver.findElement(By.id("file-upload"));
//
//        // Make sure this file exists in your project
//        String filePath = System.getProperty("user.dir") + "/src/test/resources/fileupload.txt";
//        uploadElement.sendKeys(filePath); // upload file
//
//        driver.findElement(By.id("file-submit")).click(); // click upload button
//    }
//
//    @Then("File should be uploaded successfully")
//    public void verifyUpload() {
//        String text = driver.findElement(By.tagName("h3")).getText();
//
//        if (text.equals("File Uploaded!")) {
//            System.out.println("✅ File uploaded successfully");
//        } else {
//            System.out.println("❌ File upload failed. Found text: " + text);
//        }
//
//        driver.quit();
//    }
//}
