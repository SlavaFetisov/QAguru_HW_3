package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent extends RegistrationPage{

    private final SelenideElement titleSuccessfulReg = $("#example-modal-sizes-title-lg");
    private final SelenideElement checkResultComponent = $(".modal-body");

    public ResultTableComponent checkModalTitleWindowOpen() {
        titleSuccessfulReg.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ResultTableComponent checkResult(String key, String value) {
        checkResultComponent
                .$$( "tr")
                .findBy(text(key))
                .shouldHave(text(value));
        return this;
    }

    public ResultTableComponent checkNotTable () {
        submitForm();
        $("#modal-content").shouldNotBe(visible);
        return this;
    }
}