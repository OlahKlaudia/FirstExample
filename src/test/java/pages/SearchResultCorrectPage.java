package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultCorrectPage extends BasePage {
   private static final String PARAGRAPH_TEXT = "Cheese is a dairy product produced in wide ranges of flavors, textures, and forms by coagulation of the milk protein casein.";
    public SearchResultCorrectPage(WebDriver driver) {
        super(driver);
    }

    public void page_searchresult_correct(){
        String result = driver.findElement(By.cssSelector("div[id='result-stats']")).getText();
        String[] splitString = result.split(" \\(",3);
        String numberOnly = splitString[0].replaceAll("\\D+", "");
        BigInteger bigInteger = new BigInteger(numberOnly);
        assertTrue(bigInteger.compareTo(new BigInteger("1000000")) == 1, "error message");

    }
    public void clickFirstLink(){
        WebElement openPage = driver.findElement(By.cssSelector("div.g a"));
        openPage.click();
        List<WebElement> listElement = driver.findElements(By.cssSelector("div#mw-content-text  p"));
        String paragraphText = ((WebElement)listElement.get(1)).getText();
        assertTrue( paragraphText.contains(PARAGRAPH_TEXT),"error message");
    }

}
