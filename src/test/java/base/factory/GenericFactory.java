package base.factory;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

abstract class GenericFactory implements DriverInterface {

    public WebDriver maximize(WebDriver driver) {
        driver.manage().window().maximize();
        return driver;
    }
}
