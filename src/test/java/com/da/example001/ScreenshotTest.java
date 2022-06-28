package com.da.example001;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenshotTest extends Example2Test{
    private static final String SCREENSHOTFOLDER="C:\\Users\\olahk\\Documents\\ceges\\example\\target\\screnshots\\";
    private static final Random RANDOMNUMBER = new Random();
   private static final String SCREENSHOTNAME = "screenshot" + RANDOMNUMBER.nextInt() + ".png";
    @Test

    public void helloWikipediaTest() {
        String cheeseurl = "https://en.wikipedia.org/wiki/Hello";
        getDriver().get(cheeseurl);
        createscreenShot();
        makeScreenshotOnFailure();
    }
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
    public  void createscreenShot(){
        TakesScreenshot screenshot =((TakesScreenshot)getDriver());
        File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(SrcFile, new File(SCREENSHOTFOLDER + SCREENSHOTNAME));
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Allure.addAttachment("Failer", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }

    }

}
