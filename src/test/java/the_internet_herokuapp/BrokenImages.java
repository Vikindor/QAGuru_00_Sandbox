package the_internet_herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BrokenImages {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void shouldCheckImagePath() {
        open("/broken_images");

        int imgTotal = $$(".example img").size(); //Get total number of images
        for (int i = 0; i < imgTotal; i++) {
            String imgSrc = $$(".example img").attributes("src").get(i); //Get <img src> for each image
            if (imgSrc.startsWith("img/")) {
                System.out.println("Image #" + (i + 1) + " - OK");
            } else {
                System.out.println("Path error for image #" + (i + 1) + ": " + imgSrc);
            }
        }
    }

    @AfterAll
    static void terminateWebDriver() {
        closeWebDriver();
    }

}