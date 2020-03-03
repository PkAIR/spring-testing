package example.common;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidChromeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");

        try {
            return new RemoteWebDriver(URI.create("http://localhost:4445/wd/hub")
                    .toURL(), browser);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
