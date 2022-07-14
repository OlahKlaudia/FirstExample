package base;

import org.openqa.selenium.WebDriver;
import pages.BrowserFactory;
import java.net.MalformedURLException;

public class DriverFactory {

    public WebDriver getRemoteMode(BrowsersEnum browser, String url) throws MalformedURLException {
        return new BrowserFactory().createRemoteWebDriver(browser, url);
    }

    public WebDriver getSimpleMode(BrowsersEnum browser) {
        return new BrowserFactory().createDriver(browser);
    }

}
