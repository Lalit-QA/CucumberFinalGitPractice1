package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import base.TestBase;

import java.io.IOException;

public class Hooks extends TestBase {

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        System.out.println("▶ START SCENARIO: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver); // 🔥 Allure attachment
        }
        closeDriver();
    }
}