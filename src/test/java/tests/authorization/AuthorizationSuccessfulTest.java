package tests.authorization;

import org.junit.jupiter.api.*;

import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tests.TestData.login;
import static tests.TestData.password;


public class AuthorizationSuccessfulTest extends TestBase {

    @Test
    void authorizationSuccessfulTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton()
                    .fillingLoginField(login)
                    .fillingPasswordField(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            mainPage.checkResultOfAuthorization(login);
        });
    }

    @AfterEach
    void afterAllAuthorizationSuccessfulTest() {
        mainPage.logOut();

    }

}
