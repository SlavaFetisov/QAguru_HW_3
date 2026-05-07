package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.examples.TestBase;


import static testData.TestData.*;
import static testData.TestData.messageAfterSubmitting;
import static testData.TestData.messagePracticeForm;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    //TestBase testData = new TestBase();

    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                //.removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeUserNumber(userNumber)
//                .setDateOfBirth(day, month, year)
//                .setSubjects(subjects)
//                .setHobbiesWrapper(hobbies)
//                .setUploadPicture(uploadfile)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderWrapper)
                .checkResult("Mobile", userNumber)
//                .checkResult("Date of Birth", year + "-" + monthNumber + "-" + day)
//                .checkResult("Subjects", subjects)
//                .checkResult("Hobbies", hobbies)
//                .checkResult("Picture", uploadfile)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void requiredTestFields() {
        registrationPage.openPage()
                //.removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeUserNumber(userNumber)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genderWrapper)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeWrongEmailTest() {
        registrationPage.openPage()
                //.removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .typeUserEmail(wrongEmail)
                .setGender(genderWrapper)
                .submitButton()
                .checkFileResultError();
    }

    @Test
    void negativeWrongNumberTest() {
        registrationPage.openPage()
                // .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(wrongNumber)
                .typeUserEmail(userEmail)
                .setGender(genderWrapper)
                .submitButton()
                .checkFileResultError();
    }

}