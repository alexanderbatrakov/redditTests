package tests.authorization;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class AuthorizationUnsuccessfulTests extends TestBase {

    @Test
    void authorizationWrongLoginTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(wrongLogin())
                    .fillingPasswordField(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkIncorrectLoginError();
        });
    }

    @Test
    void authorizationWrongPasswordTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(login)
                    .fillingPasswordField(wrongPassword)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkIncorrectLoginError();
        });
    }

    @Test
    void authorizationWrongLoginAndPasswordTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(wrongLogin())
                    .fillingPasswordField(wrongPassword)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkIncorrectLoginError();
        });
    }

    @Test
    void authorizationShortLoginTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(shortLogin())
                    .fillingPasswordField(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkShortOrLongLoginError();
        });
    }

    @Test
    void authorizationLongLoginTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(longLogin())
                    .fillingPasswordField(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkShortOrLongLoginError();
        });
    }

    @Test
    void authorizationEmptyLoginTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
        });
        step("Check required attribute", () -> {
            mainPage.checkEmptyLoginAttribute();
        });
    }

    @Test
    void authorizationEmptyPasswordTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
        });
        step("Check required attribute", () -> {
            mainPage.checkEmptyPasswordAttribute();
        });
    }
}
