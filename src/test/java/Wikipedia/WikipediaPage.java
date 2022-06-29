package Wikipedia;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WikipediaPage extends TestBase {
    WebElement INPUTELEMENT = getDriver().findElement(By.cssSelector("input[name='search']"));
    public String getTitleTextinWikipedia() {
        WebElement element = getDriver().findElement(By.cssSelector("#www-wikipedia-org > div.central-textlogo > h1"));
        return element.getText();
    }
    public void writeSearchText(String search) {
        INPUTELEMENT.sendKeys(search);
    }
    public CheckTheParagraphPage enterOnTheSearshButton() {
        INPUTELEMENT.sendKeys(Keys.ENTER);
        return new CheckTheParagraphPage();
    }

}
