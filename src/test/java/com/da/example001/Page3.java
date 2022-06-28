package com.da.example001;

import org.openqa.selenium.By;


import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Page3 extends ExampleTest {

    public void page_searchresult_correct(){
        String result = getDriver().findElement(By.cssSelector("div[id='result-stats']")).getText();
        String[] splitString = result.split(" \\(",3);
        String numberOnly = splitString[0].replaceAll("\\D+", "");
        BigInteger bigInteger = new BigInteger(numberOnly);
        assertTrue(bigInteger.compareTo(new BigInteger("1000000")) == 1, "error message");

    }
}
