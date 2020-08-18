package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import com.codeborne.selenide.Screenshots;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    public HomePage() {
    }

    public void userIconIsDisplayed() {
        $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);
    }

    public File captureScreenshot() {
        File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");
        File screenshot = Screenshots.takeScreenShotAsFile();
        Path pathToScreenshot = Paths.get(screenshot.getPath());
        try {
            String currTime = java.time.LocalTime.now().toString().replace(":", ".");
            String screenshotName = screenshotsFolder + "/" + "Screenshot_" + currTime + ".png";
            Files.copy(pathToScreenshot, Paths.get(screenshotName), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }

}