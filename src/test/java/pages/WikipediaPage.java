package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage extends BasePage {
    WebElement inputElement = driver.findElement(By.cssSelector("input[name='search']"));

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleTextinWikipedia() {
        WebElement element = driver.findElement(By.cssSelector("#www-wikipedia-org > div.central-textlogo > h1"));
        return element.getText();
    }

    public void writeSearchText(String search) {
        inputElement.sendKeys(search);
    }

    public CheckTheParagraphPage enterOnTheSearshButton() {
        inputElement.sendKeys(Keys.ENTER);
        return new CheckTheParagraphPage(driver);
    }

}
