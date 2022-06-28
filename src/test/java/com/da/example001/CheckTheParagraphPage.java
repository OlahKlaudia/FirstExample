package com.da.example001;

import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckTheParagraphPage extends TestBase {
    public String searchandenter() {
        String testText = "\"Hello, World!\"";
        String listElement = getDriver().findElement(By.cssSelector("h1#firstHeading")).getText();
        String[] splitString = listElement.split("program");
        String paragraphText = listElement;
        assertTrue(paragraphText.contains(testText), "error message");
        return paragraphText;
    }
    public String getTitleText() {
        return getDriver().findElement(By.cssSelector("h1#firstHeading")).getText();
    }
}
