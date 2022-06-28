package com.da.example001;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Page2 extends ExampleTest {

    public void pageenter(){
        WebElement searchInput = getDriver().findElement(By.cssSelector("input[name='q']"));
        searchInput.sendKeys("cheese");
        searchInput.sendKeys(Keys.ENTER);

    }
}
