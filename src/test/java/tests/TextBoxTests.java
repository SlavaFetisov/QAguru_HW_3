package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testData.TestData;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();

    @Test
    void successfullFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitButton()
                .checkField("name", testData.firstName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);

    }

    @Test
    void successfullFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.userEmail)
                .submitButton()
                .checkField("name", testData.firstName)
                .checkField("email", testData.userEmail);
    }

    @Test
    void successfullFillFormWithoutAddressTest_chaining() {
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.userEmail)
                .submitButton()
                .checkField("name", testData.firstName)
                .checkField("email", testData.userEmail);
    }

    @Test
    void negativeFillFormTest() {
        textBoxPage.openPage()
                .typeUserEmail(testData.wrongEmail)
                .submitButton()
                .checkFieldError();
    }

    @Test
    void miniFieldTest() {
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .submitButton()
                .checkField("name", testData.firstName);
    }
}