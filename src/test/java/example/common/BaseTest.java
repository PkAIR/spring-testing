package example.common;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        if (testInfo.getTags().contains("selenoid")) {
            Configuration.driverManagerEnabled = false;
            Configuration.browser = SelenoidChromeDriverProvider.class.getName();
        }
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
