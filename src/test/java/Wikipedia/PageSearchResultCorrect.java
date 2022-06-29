package Wikipedia;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageSearchResultCorrect extends TestBase {
   private static final String PARAGRAPHTEXT = "Cheese is a dairy product produced in wide ranges of flavors, textures and forms by coagulation of the milk protein casein.";

    public void page_searchresult_correct(){
        String result = getDriver().findElement(By.cssSelector("div[id='result-stats']")).getText();
        String[] splitString = result.split(" \\(",3);
        String numberOnly = splitString[0].replaceAll("\\D+", "");
        BigInteger bigInteger = new BigInteger(numberOnly);
        assertTrue(bigInteger.compareTo(new BigInteger("1000000")) == 1, "error message");

    }
    public void clickFirstLink(){
        WebElement openpage = getDriver().findElement(By.cssSelector("div.g a"));
        openpage.click();
        List<WebElement> listElement = getDriver().findElements(By.cssSelector("div#mw-content-text  p"));
        String paragraphText = ((WebElement)listElement.get(1)).getText();
        assertTrue( paragraphText.contains(PARAGRAPHTEXT),"error message");

    }
}
