package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.ChromeCapabilitieProperties;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.time.Duration;

@ExtendWith(ExtensionExample.class)
abstract public class TestBase {
    private static WebDriver driver;
    private static final String URL = "http://192.168.0.146:4444/wd/hub";
    private static final String BROWSER_PROPERTIES = System.getProperty("browser");
    private static boolean BROWSER_REMOTE = Boolean.parseBoolean(System.getProperty("remote"));

    @BeforeEach
    public void beforeTest() throws MalformedURLException, UnknownHostException {
        InetAddress address2 = InetAddress.getByName("45.22.30.39");
        System.out.println(BROWSER_REMOTE);
        if (BROWSER_PROPERTIES == null) {
            driver = new DriverFactory().getRemoteMode(BrowsersEnum.CHROME, URL);
        }
        System.getProperty("browser");

        if (BROWSER_REMOTE) {
            driver = new DriverFactory().getRemoteMode(convertedIntoEnumToString(), URL);//address2.getHostName()
        } else {
            driver = new DriverFactory().getSimpleMode(convertedIntoEnumToString());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public BrowsersEnum convertedIntoEnumToString() {
        for (BrowsersEnum browsersEnum : BrowsersEnum.values()) {
            if (BROWSER_PROPERTIES.equalsIgnoreCase(browsersEnum.getName())) {
//                browsersEnum.getName();
                return browsersEnum;
            } else
                System.out.println("default");
        }
    return null;
    }
    @AfterEach
    public void afterTest() {
        driver.close();
    }

    @AfterAll
    public static void afterTestBaseClass(){
        new ChromeCapabilitieProperties().createEnvironmentFile();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}

