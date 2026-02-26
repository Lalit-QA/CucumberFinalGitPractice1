package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED : " + result.getName());
        ScreenshotUtil.takeScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED : " + result.getName());
    }
}