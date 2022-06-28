package com.da.example001;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaTest extends TestBase {

    private static final String WIKIPEDIA_URL ="https://www.wikipedia.org/";
    private static final String HELLO_WORLD_TITLE = "\"Hello, World!\" programv";
    private static final String SEARCH_TEXT = "Hello world";


    @Test
    public void wikipediaTitleTest() {
        WikipediaPage wkPage = navigateToWikipediaPage();
        System.out.println(wkPage.getTitleText());
    }

    @Test
    public void wikipediaSearchTest() {

            WikipediaPage wkPage = navigateToWikipediaPage();

        wkPage.enterSearchText(SEARCH_TEXT);
        CheckTheParagraphPage checkTheParagraphPage = wkPage.clickOnTheSearshButton();
        checkTheParagraphPage.searchandenter();
        assertEquals(checkTheParagraphPage.getTitleText(), HELLO_WORLD_TITLE);
        Allure.addAttachment("Failer", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    private WikipediaPage navigateToWikipediaPage() {
        getDriver().get(WIKIPEDIA_URL);
        return new WikipediaPage();
    }

}
