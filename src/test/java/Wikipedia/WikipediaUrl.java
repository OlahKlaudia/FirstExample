package Wikipedia;

import Base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


@Epic("Web shop")
@Feature("Web shop function tests")
public class WikipediaUrl extends TestBase {
    private static final String WIKIPEDIAURL = "https://www.wikipedia.org/";
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

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
