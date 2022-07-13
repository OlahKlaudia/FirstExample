package test;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.CheckTheParagraphPage;
import pages.WikipediaPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaTest extends TestBase {

    private static final String WIKIPEDIA_URL ="https://www.wikipedia.org/";
    private static final String HELLO_WORLD_TITLE = "\"Hello, World!\" program";
    private static final String SEARCH_TEXT = "Hello world";

    @Test
    public void wikipediaTitleTest() {
        WikipediaPage wkPage = navigateToWikipediaPage();
        System.out.println(wkPage.getTitleTextinWikipedia());
    }

    @Test
    public void wikipediaSearchTest() {
        WikipediaPage wkPage = navigateToWikipediaPage();
        wkPage.writeSearchText(SEARCH_TEXT);
        CheckTheParagraphPage checkTheParagraphPage = wkPage.enterOnTheSearshButton();
        assertEquals(checkTheParagraphPage.getTitleTextHelloWorld(), HELLO_WORLD_TITLE);
    }

    private WikipediaPage navigateToWikipediaPage() {
        getDriver().get(WIKIPEDIA_URL);
        return new WikipediaPage(getDriver());
    }

}
