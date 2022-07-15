package base.factory;

import base.BrowsersEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeHeadlessFactory extends GenericFactory{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeoptions = new EdgeOptions();
        return maximize(new EdgeDriver(edgeoptions.setHeadless(true)));
    }

    @Override
    public WebDriver createRemoteDriver(BrowsersEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver = maximize(new RemoteWebDriver(new URL(url), new EdgeOptions().setHeadless(true)));
        return driver;

    }



}
