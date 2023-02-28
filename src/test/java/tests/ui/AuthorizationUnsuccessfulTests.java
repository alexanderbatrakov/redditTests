package tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class AuthorizationUnsuccessfulTests extends TestBase {

    @Test
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with wrong login")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with wrong password")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with wrong login and password")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with short login (less 3 characters)")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with long login (more 20 characters)")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with empty login field")
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
    @Owner("batrakov")
    @Tag("Web")
    @DisplayName("Authorization with empty password field")
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
