package tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

@Owner("batrakov")
@Tag("Web")
public class AuthorizationUnsuccessfulTests extends TestBase {

    private static String incorrectLoginOrPassError = "Incorrect username or password";
    private static String shortOrLongLoginError = "Username must be between 3 and 20 characters";

    static Stream<Arguments> testDataForUnsuccessfulTests() {
        return Stream.of(
                Arguments.of(wrongLogin(), password, incorrectLoginOrPassError, "Authorization with wrong login"),
                Arguments.of(login, wrongPassword, incorrectLoginOrPassError, "Authorization with wrong password"),
                Arguments.of(wrongLogin(), wrongPassword, incorrectLoginOrPassError, "authorization with wrong login and password"),
                Arguments.of(shortLogin(), password, shortOrLongLoginError, "Authorization with short login (less 3 characters)"),
                Arguments.of(longLogin(), password, shortOrLongLoginError, "Authorization with long login (more 20 characters)")
        );
    }

    @ParameterizedTest(name = "{3}")
    @MethodSource("testDataForUnsuccessfulTests")
    void authorizationWrongLoginTest(String login, String password, String textOfError, String nameOfTest) {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
            authorizationModalPage.setLogin(login)
                    .setPassword(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            authorizationModalPage.checkIncorrectLoginError(textOfError);
        });
    }

    @Test
    @DisplayName("Authorization with empty login field")
    void authorizationEmptyLoginTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
        });
        step("Check required attribute", () -> {
            authorizationModalPage.checkEmptyLoginAttribute();
        });
    }

    @Test
    @DisplayName("Authorization with empty password field")
    void authorizationEmptyPasswordTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
        });
        step("Check required attribute", () -> {
            authorizationModalPage.checkEmptyPasswordAttribute();
        });
    }
}
