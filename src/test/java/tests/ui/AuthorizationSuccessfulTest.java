package tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.login;
import static tests.TestData.password;

@Owner("batrakov")
@Tag("Web")
public class AuthorizationSuccessfulTest extends TestBase {

    @Test
    @DisplayName("Successful authorization")
    void authorizationSuccessfulTest() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", () -> {
            mainPage.clickOnLogInButton();
            authorizationModalPage.setLogin(login)
                    .setPassword(password)
                    .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", () -> {
            authorizationModalPage.checkResultOfAuthorization(login);
        });
    }

}
