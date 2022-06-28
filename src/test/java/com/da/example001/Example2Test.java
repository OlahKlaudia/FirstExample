package com.da.example001;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Epic("Web shop")
@Feature("Web shop function tests")
public class Example2Test extends TestBase {



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
    public void cheeseTest() {

        String cheeseurl = "https://www.wikipedia.org/";
        getDriver().get(cheeseurl);

    }
//    @Attachment
//    public String performedActions(Example2Test actionSequence) {
//        return actionSequence.toString();
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }
@Attachment("Screenshot on failure")
public byte[] makeScreenshot() {
    return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
}

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
