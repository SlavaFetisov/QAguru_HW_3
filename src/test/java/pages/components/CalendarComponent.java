package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement yearPicker = $(".react-datepicker__year-select");
    private SelenideElement monthPicker = $(".react-datepicker__month-select");
    private String dayPicker = ".react-datepicker__day.react-datepicker__day--0%s" +
            ":not(.react-datepicker__day--outside-month))";

    public void setDate(String day, String month, String year) {
        yearPicker.selectOption(year);
        monthPicker.selectOption(month);
        String formattedDayLocator = String.format(dayPicker, day);
        $(formattedDayLocator).click();

    }
}