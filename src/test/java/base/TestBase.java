package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

@ExtendWith(ExtensionExample.class)
abstract public class TestBase {

    private static final String ENVIRONMENT_PROPERTIES = ".\\target\\allure-results\\";
    private static final String FILENAME = "environment.properties";
    private static WebDriver driver;
    private static final String URL = "http://192.168.0.146:4444/wd/hub";
    private static final String BROWSER_PROPERTIES = System.getProperty("browser");
    private static boolean BROWSER_REMOTE = Boolean.parseBoolean(System.getProperty("remote"));

    @BeforeEach
    public void beforeTest() throws MalformedURLException {
        System.out.println(BROWSER_REMOTE);
        if (BROWSER_PROPERTIES == null) {
            driver = new DriverFactory().createRemoteWebDriver(BrowsersEnum.CHROME, URL);
        }
        System.getProperty("browser");
        whenConvertedIntoEnum_thenGetsConvertedCorrectly();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    public void whenConvertedIntoEnum_thenGetsConvertedCorrectly() throws MalformedURLException {
        for (BrowsersEnum env : BrowsersEnum.values()) {
            if (BROWSER_PROPERTIES.equalsIgnoreCase(env.getName())) {
                env.getName();
                if (BROWSER_REMOTE) {
                    driver = new DriverFactory().createRemoteWebDriver(env, URL);
                } else {
                    driver = new DriverFactory().createDriver(env);
                }
            } else
                System.out.println("default");
        }
    }

    @AfterEach
    public void afterTest() {
        driver.close();
    }

    @AfterAll
    public static void afterTestBaseClass() {
        createEnvironmentFile();
    }

    private static void createEnvironmentFile() {//TODO need refactor
        String name = "ChromeDriver \n";
        String version = "102.0.5005.61 ";
        String port = "59003";

        try {
            FileOutputStream outputStream = new FileOutputStream(ENVIRONMENT_PROPERTIES + FILENAME);
            byte[] strByte = name.getBytes();
            outputStream.write(strByte);
            byte[] vrsByte = version.getBytes();
            outputStream.write(vrsByte);
            byte[] prtByte = port.getBytes();
            outputStream.write(prtByte);
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

