package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void setupConfig(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://1001tur.ru";
        Configuration.timeout = 10000;
    }

    @AfterEach
    void closeBrowser(){

        closeWebDriver();
    }

}
