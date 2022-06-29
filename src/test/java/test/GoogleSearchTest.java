package test;

import Base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.GoogleSearchPage;
import pages.SearchResultCorrectPage;

@Epic("Web shop")
@Feature("Web shop function tests")
public class GoogleSearchTest extends TestBase {
    private static final String WIKIPEDIAURL = "https://www.google.com/";
    @Test
    @Owner("Olah Klaudia")
    @Story("Testing search")
    @DisplayName("Product search")
    @Description("description")
    @Link("name = \"AP-XYZ name of the link\", url= JIRA_TICKET_URL + \"AP-XYZ\"")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("123")
    @TmsLink("test")
    @Step("Type {user.name} / {user.password}.")
    @Flaky
    public void wikipediaUrl() {
        getDriver().get(WIKIPEDIAURL);
        makeScreenshot();
    }
    @Test
    public void wikipediaSearchTest() {
        GoogleSearchPage wkPage = googleUrl();
        wkPage.pageWriteTheInputAndEnter();
        SearchResultCorrectPage checkTheParagraphPage = wkPage.enterOnTheSearshButton();
        checkTheParagraphPage.page_searchresult_correct();
        checkTheParagraphPage.clickFirstLink();

    }
    private GoogleSearchPage googleUrl() {
        getDriver().get(WIKIPEDIAURL);
        return new GoogleSearchPage(getDriver());
    }
    @Attachment("Screenshot on failure")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
