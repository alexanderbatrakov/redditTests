package tests.ui.pages;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage openPage() {
        open("https://www.reddit.com/");
        return this;
    }

    public MainPage clickOnLogInButton() {
        $("header").$(Selectors.byText("Log In")).click();

        return this;
    }
    public MainPage clickOnPopularButton() {
        $("#focus-Popular").click();

        return this;
    }
    public MainPage clickOnTopicButton(String nameOfTopic) {
        $$("._2ChaQYEC5d_hjd-mltzvQK").findBy(text(nameOfTopic)).click();

        return this;
    }
}
