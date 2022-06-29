package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverFactory {
    public WebDriver createDriver(BrowsersEnum browser) {
        switch (browser)
        {
            case chrome:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case edge:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }

    }
}
