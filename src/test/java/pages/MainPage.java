package pages;

import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private String incorrectLoginOrPassError = "Incorrect username or password";
    private String shortOrLongLoginError = "Username must be between 3 and 20 characters";
    public MainPage openPage() {
        open("");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


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

    public MainPage logOut (){
    $("#email-collection-tooltip-id").click();
    $("._2uYY-KeuYHKiwl-9aF0UiL").$(new ByText("Log Out")).click();
        return this;
    }

    public MainPage checkIncorrectLoginError(){
        $(".login").shouldHave(text(incorrectLoginOrPassError));
        return this;
    }
    public MainPage checkShortOrLongLoginError (){
        $(".login").shouldHave(text(shortOrLongLoginError));
        return this;
    }

    public MainPage checkEmptyLoginAttribute (){
        switchTo().frame(0);
        $("#loginUsername").shouldHave(attribute("required"));
        return this;
    }
    public MainPage checkEmptyPasswordAttribute (){
        switchTo().frame(0);
        $("#loginPassword").shouldHave(attribute("required"));
        return this;
    }


}
