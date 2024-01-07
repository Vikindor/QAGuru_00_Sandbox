package the_internet_herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AddOrRemoveElements {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void shouldAddAndDeleteElements() {
        open("/add_remove_elements/");

        //Add 10 elements
        for (int i=0; i < 10; i ++) {
            $(".example").$(byText("Add Element")).click();
        }

        //Delete 7 elements
        for (int i=0; i < 5; i ++) {
            $(".example").$(byText("Delete")).click();
        }

        //It's not a list on the website, all elements just go in single div like that
        $("#elements").shouldHave(exactText("DeleteDeleteDeleteDeleteDelete")); //5 elements
    }

    @AfterAll
    static void terminateWebDriver() {
        closeWebDriver();
    }

}