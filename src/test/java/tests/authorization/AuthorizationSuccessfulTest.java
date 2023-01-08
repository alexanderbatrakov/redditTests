package tests.authorization;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.TestBase;


import static tests.TestData.login;
import static tests.TestData.password;


public class AuthorizationSuccessfulTest extends TestBase {

    @Test
    void authorizationSuccessfulTest() {
        mainPage.openPage()
                .clickOnLogInButton()
                .fillingLoginField(login)
                .fillingPasswordField(password)
                .clickOnLogInButtonOnFrame()
                .checkResultOfAuthorization(login);
    }

    @AfterAll
    static void beforeAllAuthorizationSuccessfulTest() {
        mainPage.logOut();
    }

}
