package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testData.TestData;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();

    @Test
    void fullForm() {

        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .submitForm();

        textBoxPage.checkField("name", testData.userName)
                .checkField("email", testData.userEmail);
    }

    @Test
    void fullForm_with_faker() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitForm();

        textBoxPage.checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void fullForm_with_utils() {

        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .submitForm();

        textBoxPage.checkField("name", testData.userName)
                .checkField("email", testData.userEmail);
    }

    @Test
    void negativeEmailForm() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.typeUserEmail(testData.inCorrectEmail);
        textBoxPage.submitForm();

        textBoxPage.invisibleResult();
    }
}