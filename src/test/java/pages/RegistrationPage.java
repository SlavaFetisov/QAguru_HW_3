package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import utils.CloseAd;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName= $("#lastName");
    private final SelenideElement userEmail= $("#userEmail");
    private final SelenideElement genderContainer= $("#genterWrapper");
    private final SelenideElement userNumber= $("#userNumber");
    private final SelenideElement subjects= $("#subjectsInput");
    private final SelenideElement hobbies= $("#hobbiesWrapper");
    private final SelenideElement uploadPicture= $("#uploadPicture");
    private final SelenideElement currentAddress= $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        CloseAd.closeAd();
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage typeGenderWrapper (String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month,year);
        return this;
    }

    public RegistrationPage selectSubject(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String value) {
        hobbies.find(byText(value)).click();
        return this;
    }

    public RegistrationPage loadPicture(String nameOfFile) {
        uploadPicture.uploadFromClasspath("img/" + nameOfFile);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

}