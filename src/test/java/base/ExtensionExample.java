package base;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.*;

public class ExtensionExample implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestBase testbase = (TestBase) context.getRequiredTestInstance();
        new ScreenshotCreater().createScreenShot(testbase.getDriver(), context.getDisplayName());
    }

}

