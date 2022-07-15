package base.factory;

import base.BrowsersEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxFactory extends GenericFactory{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return maximize(new FirefoxDriver());
    }

    @Override
    public WebDriver createRemoteDriver(BrowsersEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver = maximize(new RemoteWebDriver(new URL(url), new FirefoxOptions()));
        return driver;
    }


}
