package com.da.example001;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WikipediaPage extends ExampleTest {

    public String getTitleText() {
        WebElement element = getDriver().findElement(By.cssSelector("#www-wikipedia-org > div.central-textlogo > h1"));
        return element.getText();
    }
    public void enterSearchText(String search) {
        WebElement element = getDriver().findElement(By.cssSelector("input[name='search']"));
        element.sendKeys(search);
    }
    public CheckTheParagraphPage clickOnTheSearshButton() {
        WebElement searchInput = getDriver().findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys(Keys.ENTER);
        return new CheckTheParagraphPage();
    }

}
