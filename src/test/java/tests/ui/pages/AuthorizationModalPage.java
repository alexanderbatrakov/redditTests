package tests.ui.pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AuthorizationModalPage {


    public AuthorizationModalPage setLogin(String login) {
        switchTo().frame($("._25r3t_lrPF3M6zD2YkWvZU"));
        $("#loginUsername").val(login);

        return this;
    }

    public AuthorizationModalPage setPassword(String password) {
        $("#loginPassword").val(password);
        return this;
    }

    public AuthorizationModalPage clickOnLogInButtonOnFrame() {

        $(".m-full-width").click();
        return this;
    }

    public AuthorizationModalPage checkResultOfAuthorization(String login) {
        $(".header-user-dropdown").shouldHave(text(login));
        return this;
    }

    public AuthorizationModalPage checkIncorrectLoginError(String textOfError) {
        $(".login").shouldHave(text(textOfError));
        return this;
    }

    public AuthorizationModalPage checkEmptyLoginAttribute() {
        switchTo().frame($("._25r3t_lrPF3M6zD2YkWvZU"));
        $("#loginUsername").shouldHave(attribute("required"));
        return this;
    }

    public AuthorizationModalPage checkEmptyPasswordAttribute() {
        switchTo().frame($("._25r3t_lrPF3M6zD2YkWvZU"));
        $("#loginPassword").shouldHave(attribute("required"));
        return this;
    }


}
