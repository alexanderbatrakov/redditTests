package pages;

import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public MainPage openPage() {
        open("https://www.reddit.com/");


        return this;
    }

    public MainPage clickOnLogInButton() {
        $("header").$(new ByText("Log In")).click();

        return this;
    }

    public MainPage fillingLoginField(String login) {
        switchTo().frame(0);
        $("#loginUsername").val(login);

        return this;
    }

    public MainPage fillingPasswordField(String password) {
        $("#loginPassword").val(password);
        return this;
    }

    public MainPage clickOnLogInButtonOnFrame() {

        $(".m-full-width").click();
        return this;
    }

    public MainPage checkResultOfAuthorization(String login) {
        $(".header-user-dropdown").shouldHave(text(login));
        return this;
    }
}
