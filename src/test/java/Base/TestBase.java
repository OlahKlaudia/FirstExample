package Base;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

@ExtendWith(ExtensionExample.class)
abstract public class TestBase {

    private static final BrowsersEnum BROWSER = BrowsersEnum.chrome;
    private static final String ENVIRONMENT_PROPERTIES=".\\target\\allure-results\\";
    private static final String FILENAME="environment.properties";
    private static WebDriver driver;

    @BeforeEach
    public void beforeTest() {
        driver = new DriverFactory().createDriver(BROWSER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterTestBaseClass() {
        driver.close();
        createEnvironmentFile();
        }

    private static void createEnvironmentFile(){//TODO need refactor
        String name = "ChromeDriver ";
        String version = "102.0.5005.61 ";
        String port = "59003";

        try {
            FileOutputStream outputStream= new FileOutputStream(ENVIRONMENT_PROPERTIES + FILENAME);
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

