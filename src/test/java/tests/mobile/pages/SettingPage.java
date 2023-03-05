package tests.mobile.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SettingPage {

    @Step("Click on view options button")
    public SettingPage clickOnMainButtons(String numberOfButton) {
        $(xpath("//android.view.ViewGroup[" + numberOfButton + "]/android.widget.FrameLayout/android.widget.TextView")).click();
        return this;
    }

    @Step("Select one of the options from button sheet")
    public SettingPage clickOnButtonSheet(String nameOfButton) {
        $(xpath("//android.widget.TextView[@text='" + nameOfButton + "']")).click();
        return this;
    }

    @Step("Check that classic view was set up")
    public SettingPage checkSetUpOfOptions(String numberOfButton, String nameOfButton) {
        $(xpath("//android.view.ViewGroup[" + numberOfButton + "]/android.widget.FrameLayout/android.widget.TextView")).shouldHave(text(nameOfButton));
        return this;
    }

}
