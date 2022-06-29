package Wikipedia;

import Base.TestBase;
import org.openqa.selenium.By;

public class CheckTheParagraphPage extends TestBase {

    public String getTitleTextHelloWorld() {
        return getDriver().findElement(By.cssSelector("h1#firstHeading")).getText();
    }
}
