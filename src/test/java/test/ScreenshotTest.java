package test;

import Base.ScreenshotCreater;
import Base.TestBase;
import org.junit.jupiter.api.Test;
public class ScreenshotTest extends TestBase {
    private static final String URLTHEWEBSITE = "https://en.wikipedia.org/wiki/Hello";
    @Test
    public void helloWikipediaTest() {
        getDriver().get(URLTHEWEBSITE);
        new ScreenshotCreater().createScreenShot(getDriver());
    }

}
