package com.da.example001;

import io.qameta.allure.Epic;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

abstract public class TestBase {

    private static final BrowsersEnum BROWSER = BrowsersEnum.chrome;
    private static final String ENVIRONMENT_PROPERTIES="C:\\Users\\olahk\\Documents\\ceges\\example\\target\\allure-results\\";
    private static final String FILENAME="environment.properties2";

    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new DriverFactory().createDriver(BROWSER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Epic("TestBase")

    @AfterAll
    public static void afterTestBaseClass() {
        driver.close();
        createEnvironmentFile();

        }
    private static void createEnvironmentFile(){
        String s = "hello";

//        System.out.println("Browser Name is : "+((DriverFactory) getDriver()).createDri);
//        System.out.println("Browser Version is : "+((RemoteWebDriver) driver).getCapabilities().getVersion().toString());
//        System.out.println("Platform Name is : "+((RemoteWebDriver) driver).getCapabilities().getPlatform().toString());
        try {
            FileOutputStream outputStream= new FileOutputStream(ENVIRONMENT_PROPERTIES + FILENAME);
            byte[] strByte = s.getBytes();
            outputStream.write(strByte);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }

}

