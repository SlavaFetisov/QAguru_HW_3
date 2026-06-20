package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;
import testData.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    TestData testData  = new TestData();

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "149";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; // default 4000
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}