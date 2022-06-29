package Wikipedia;

import Base.BasePage;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckTheParagraphPage extends BasePage {

    public CheckTheParagraphPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleTextHelloWorld() {
        return driver.findElement(By.cssSelector("h1#firstHeading")).getText();
    }
}
