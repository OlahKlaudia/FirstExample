package base.factory;

import base.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;


public class DriverFactory {

    public WebDriver createDriver(BrowsersEnum browser) {
        switch (browser) {
            case CHROME:
                return new ChromeFactory().createDriver();
            case EDGE:
                return new  EdgeFactory().createDriver();
            case FIREFOX:
                return new FireFoxFactory().createDriver();
            case EDGEHEADLESS:
                return new EdgeHeadlessFactory().createDriver();
            case FIREFOXHEADLESS:
            return new FirefoxHeadlessFactory().createDriver();
            default:
                return new ChromeDriver();
        }
    }

    public WebDriver createRemoteWebDriver(BrowsersEnum browser, String url) throws MalformedURLException {
        switch (browser) {
            case EDGE:
                return new EdgeFactory().createRemoteDriver(browser, url);
            case FIREFOX:
                return new FireFoxFactory().createRemoteDriver(browser, url);
            case EDGEHEADLESS:
                return new EdgeHeadlessFactory().createRemoteDriver(browser, url);
            case FIREFOXHEADLESS:
               return new FirefoxHeadlessFactory().createRemoteDriver(browser, url);
            default:
                return new ChromeFactory().createRemoteDriver(browser, url);
        }
    }

}
