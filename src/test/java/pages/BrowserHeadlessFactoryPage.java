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

public class BrowserHeadlessFactoryPage {
    public WebDriver createDriverHeadless(BrowsersEnum browser) {

        switch (browser) {
            case EDGEHEADLESS:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeoptions = new EdgeOptions();
                return new EdgeDriver(edgeoptions.setHeadless(true));
            case FIREFOXHEADLESS:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions.setHeadless(true));
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                return new ChromeDriver(chromeoptions.setHeadless(true));
        }
    }

    public WebDriver createRemoteWebDriverHeadless(BrowsersEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        switch (browser) {
            case EDGEHEADLESS:
                driver = new RemoteWebDriver(new URL(url), new EdgeOptions().setHeadless(true));
                break;
            case FIREFOXHEADLESS:
                driver = new RemoteWebDriver(new URL(url), new FirefoxOptions().setHeadless(true));
                break;
            default:
                driver = new RemoteWebDriver(new URL(url), new ChromeOptions().setHeadless(true));
        }
        return driver;
    }
}
