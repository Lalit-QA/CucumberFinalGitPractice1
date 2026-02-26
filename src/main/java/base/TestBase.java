package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String env = prop.getProperty("env");
		String url = prop.getProperty(env + "Url");

		String browser = System.getProperty("browser") != null
				? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		return driver;
	}

	// Close the driver safely
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
			System.out.println("▶ BROWSER CLOSED");
		}
	}
}

//package base;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class TestBase {
//
//	protected static WebDriver driver;
//
//	public WebDriver initializeDriver() throws IOException {
//
//		FileInputStream fis = new FileInputStream(
//				System.getProperty("user.dir") + "/src/test/resources/global.properties");
//
//		Properties prop = new Properties();
//		prop.load(fis);
//
//		String env = prop.getProperty("env");
//		String url = prop.getProperty(env + "Url");
//
//		String browser = System.getProperty("browser") != null
//				? System.getProperty("browser")
//				: prop.getProperty("browser");
//
//		if (driver == null) {
//			if (browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			} else if (browser.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			}
//
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.manage().window().maximize();
//			driver.get(url);
//		}
//		return driver;
//	}
//}
