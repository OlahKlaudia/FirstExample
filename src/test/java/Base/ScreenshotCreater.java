package Base;

import Base.TestBase;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenshotCreater extends TestBase {

    private static final String SCREENSHOTFOLDER = ".\\target\\screnshots\\";
    private static final Random RANDOMNUMBER = new Random();
    private static final String SCREENSHOTNAME = "screenshot" + RANDOMNUMBER.nextInt() + ".png";

    public void createScreenShot(WebDriver driver, final String screenshotName) {
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(SrcFile, new File(SCREENSHOTFOLDER + "_" + screenshotName + "_" + SCREENSHOTNAME));
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Allure.addAttachment("Failer", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
    public void createScreenShot(WebDriver driver) {
        createScreenShot(driver, SCREENSHOTNAME);
    }
}
