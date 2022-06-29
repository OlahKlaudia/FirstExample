package Wikipedia;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void pageWriteTheInputAndEnter(){
        WebElement searchInput = driver.findElement(By.cssSelector("input[name='q']"));
        searchInput.sendKeys("cheese");
        searchInput.sendKeys(Keys.ENTER);

    }
    public PageSearchResultCorrect enterOnTheSearshButton() {
        return new PageSearchResultCorrect(driver);
    }

}
