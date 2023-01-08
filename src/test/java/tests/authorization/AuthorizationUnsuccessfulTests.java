package tests.authorization;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.TestData.*;

public class AuthorizationUnsuccessfulTests extends TestBase {

    @Test
    void authorizationWrongLoginTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(wrongLogin())
                .fillingPasswordField(password)
                .clickOnLogInButtonOnFrame()
                .checkIncorrectLoginError();
    }

    @Test
    void authorizationWrongPasswordTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(login)
                .fillingPasswordField(wrongPassword)
                .clickOnLogInButtonOnFrame()
                .checkIncorrectLoginError();
    }

    @Test
    void authorizationWrongLoginAndPasswordTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(wrongLogin())
                .fillingPasswordField(wrongPassword)
                .clickOnLogInButtonOnFrame()
                .checkIncorrectLoginError();
    }
    @Test
    void authorizationShortLoginTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(shortLogin())
                .fillingPasswordField(password)
                .clickOnLogInButtonOnFrame()
                .checkShortOrLongLoginError();
    }
    @Test
    void authorizationLongLoginTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(longLogin())
                .fillingPasswordField(password)
                .clickOnLogInButtonOnFrame()
                .checkShortOrLongLoginError();
    }
    @Test
    void authorizationEmptyLoginTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .checkEmptyLoginError();
    }
    @Test
    void authorizationEmptyPasswordTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .checkEmptyPasswordError();
    }
}
