package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.TextBoxPage;
import testData.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    protected static TextBoxPage textBoxPage = new TextBoxPage();
    protected TestData testData;

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browser = "Сhrome";
        Configuration.browserVersion = "148";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; // default 4000
        //Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void initTestData() {
        testData = new TestData();
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}