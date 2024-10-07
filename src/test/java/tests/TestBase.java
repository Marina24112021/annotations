package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.reopenBrowserOnFail = false;
        Configuration.baseUrl = "https://thecode.media";
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
