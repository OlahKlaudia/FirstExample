package base.factory;

import base.BrowsersEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeFactory extends GenericFactory{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return maximize(new EdgeDriver());
    }

    @Override
    public WebDriver createRemoteDriver(BrowsersEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver =maximize(new RemoteWebDriver(new URL(url), new EdgeOptions()));
        return driver;
    }


}
