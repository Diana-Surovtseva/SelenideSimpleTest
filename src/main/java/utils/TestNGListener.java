package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import utils.WebDriverFactory;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");
        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdir();
        }
        File screenshot = captureScreenshot();
        Path pathToScreenshot = Paths.get(screenshot.getPath());
        try {
            String currTime = java.time.LocalTime.now().toString().replace(":", ".");
            String screenshotName = screenshotsFolder + "/" + "Screenshot_" + currTime + ".png";
            Files.copy(pathToScreenshot, Paths.get(screenshotName), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private File captureScreenshot(){
        return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
    }

    @Override
    public void onTestStart(ITestResult result) {
//        String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browserName");
//        System.out.println("Browser name is " + browserName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");
        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdir();
        }
        File screenshot = captureScreenshot();
        Path pathToScreenshot = Paths.get(screenshot.getPath());
        try {
            String currTime = java.time.LocalTime.now().toString().replace(":", ".");
            String screenshotName = screenshotsFolder + "/" + "Screenshot_" + currTime + ".png";
            Files.copy(pathToScreenshot, Paths.get(screenshotName), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

