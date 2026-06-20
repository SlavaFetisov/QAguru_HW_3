package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Test
    void studentRegistrationForm() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmail)
                .typeUserNumber(testData.userNumber)
                .typeGenderWrapper(testData.genderWrapper)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .selectSubject(testData.subject)
                .selectHobbies(testData.hobbiesReading)
                .loadPicture(testData.nameOfFile)
                .typeCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .submitForm();

        resultTableComponent.checkModalTitleWindowOpen()
                .checkResult("Student Name", testData.userName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dateOfBirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbiesReading)
                .checkResult("Picture", testData.nameOfFile)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test
    void onlyRequiredFields() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeGenderWrapper(testData.genderWrapper)
                .typeUserNumber(testData.userNumber)
                .submitForm();

        resultTableComponent.checkModalTitleWindowOpen()
                .checkResult("Student Name", testData.userName)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void negativeNameFields() {
        registrationPage.openPage()
                .typeLastName(testData.lastName)
                .typeGenderWrapper(testData.genderWrapper)
                .typeUserNumber(testData.userNumber)
                .submitForm();

        resultTableComponent.checkNotTable();

    }

    @Test
    void negativeLastNameFields() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeGenderWrapper(testData.genderWrapper)
                .typeUserNumber(testData.userNumber)
                .submitForm();

        resultTableComponent.checkNotTable();
    }

    @Test
    void negativeGenderFields() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserNumber(testData.userNumber)
                .submitForm();

        resultTableComponent.checkNotTable();
    }

}