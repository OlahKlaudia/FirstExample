package base;

import org.openqa.selenium.WebDriver;
import pages.BrowserFactoryPage;
import pages.BrowserHeadlessFactoryPage;

import java.net.MalformedURLException;

public class DriverFactory {
    private static boolean BROWSER_REMOTE = Boolean.parseBoolean(System.getProperty("remote"));
    private static final String BROWSER_PROPERTIES = System.getProperty("browser");
    public WebDriver getRemoteMode(BrowsersEnum browser, String url) throws MalformedURLException {
        if (BROWSER_PROPERTIES=="headless") {
            return new BrowserHeadlessFactoryPage().createRemoteWebDriverHeadless(browser, url);
        } else {
            return new BrowserFactoryPage().createRemoteWebDriver(browser, url);
        }
    }

    public WebDriver getSimpleMode(BrowsersEnum browser){
        if (BROWSER_PROPERTIES.contains("headless")) {
            return new BrowserHeadlessFactoryPage().createDriverHeadless(browser);
        } else {
            return new BrowserFactoryPage().createDriver(browser);

        }
    }

}
