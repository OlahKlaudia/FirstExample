package base.factory;

import base.BrowsersEnum;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverInterface {
    WebDriver createDriver();
    WebDriver createRemoteDriver(BrowsersEnum browser, String url) throws MalformedURLException;
}
