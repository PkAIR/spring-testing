package example;

import example.common.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloE2ESeleniumTest extends BaseTest {
    @LocalServerPort
    private int port;

    @Test
    @Tag("local")
    public void helloPageHasTextHelloWorld() {
        open(String.format("http://localhost:%s/hello", port));
        assertThat($(By.tagName("body")).getText(), containsString("Hello World!"));
    }

    @Test
    @Tag("local")
    public void helloStrangerTest() {
        open(String.format("http://localhost:%s/hello/stranger", port));
        assertThat($(By.tagName("body")).getText(),
                containsString("Who is this 'stranger' you're talking about?"));
    }

    @Test
    @Tag("local")
    public void weatherResponseTest() {
        open(String.format("http://localhost:%s/weather", port));
        assertThat($(By.tagName("body")).getText(), is(not(emptyString())));
    }

    @Test
    @Tag("selenoid")
    public void googleCanBeOpened() throws InterruptedException {
        open("https://www.google.com/");
        assertThat($(By.xpath("//img[@alt='Google']")).isDisplayed(), is(true));
    }
}
