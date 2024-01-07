package the_internet_herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;

import java.security.Key;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BasicAuthentication {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successfulAuth() {
        //Shorter way to do it
        open("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Longer way to do it
        //open("https://admin:admin@the-internet.herokuapp.com/basic_auth", "", "admin", "admin");

        $(".example").shouldHave(text("Congratulations! You must have the proper credentials."));
    }

    @AfterAll
    static void terminateWebDriver() {
        closeWebDriver();
    }
}