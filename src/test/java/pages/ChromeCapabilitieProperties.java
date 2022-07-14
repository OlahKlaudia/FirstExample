package pages;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChromeCapabilitieProperties {
    private static final String ENVIRONMENT_PROPERTIES = ".\\target\\allure-results\\";
    private static final String FILENAME = "environment.properties";
    public static void createEnvironmentFile()  {
        try {
            FileOutputStream outputStream = new FileOutputStream(ENVIRONMENT_PROPERTIES + FILENAME);
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.getCapability(ChromeOptions.CAPABILITY);
            options.merge(capabilities);
            byte[] nameByte = options.getBrowserName().getBytes();
            outputStream.write(nameByte);
            byte[] versionByte = options.getBrowserVersion().getBytes();
            outputStream.write(versionByte);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
