package pages;

import base.BrowsersEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    public WebDriver createDriver(BrowsersEnum browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGEHEADLESS:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeoptions = new EdgeOptions();
                return new EdgeDriver(edgeoptions.setHeadless(true));
            case FIREFOXHEADLESS:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions.setHeadless(true));
            default:
                return new ChromeDriver();
        }
    }

    public WebDriver createRemoteWebDriver(BrowsersEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        switch (browser) {
            case EDGE:
                driver = new RemoteWebDriver(new URL(url), new EdgeOptions());
                break;
            case FIREFOX:
                driver = new RemoteWebDriver(new URL(url), new FirefoxOptions());
                break;
            case EDGEHEADLESS:
                driver = new RemoteWebDriver(new URL(url), new EdgeOptions().setHeadless(true));
                break;
            case FIREFOXHEADLESS:
                driver = new RemoteWebDriver(new URL(url), new FirefoxOptions().setHeadless(true));
                break;
            default:
                driver = new RemoteWebDriver(new URL(url), new ChromeOptions());
        }
        return driver;
    }
}
