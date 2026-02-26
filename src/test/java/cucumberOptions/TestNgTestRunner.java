package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/main/java/features",
		tags = "@SearchTest",
		glue = {"stepDefination", "utilities", "base"},
		plugin = {
				"pretty",
				"summary",
				"html:target/cucumber-report/cucumber2.html"
		},
		monochrome = true
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {
}