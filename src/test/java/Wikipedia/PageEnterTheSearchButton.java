package Wikipedia;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PageEnterTheSearchButton extends TestBase {

    public void pageWriteTheInputAndEnter(){
        WebElement searchInput = getDriver().findElement(By.cssSelector("input[name='q']"));
        searchInput.sendKeys("cheese");
        searchInput.sendKeys(Keys.ENTER);

    }
    public PageSearchResultCorrect enterOnTheSearshButton() {
        return new PageSearchResultCorrect();
    }

}
