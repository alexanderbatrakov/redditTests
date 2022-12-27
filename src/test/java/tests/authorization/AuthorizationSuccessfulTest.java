package tests.authorization;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import tests.TestData;

import static tests.TestData.login;
import static tests.TestData.password;


public class AuthorizationSuccessfulTest extends TestBase {
@Test
    void authorizationSuccessfulTest(){
     mainPage.openPage()
             .clickOnLogInButton()
             .fillingLoginField(login)
             .fillingPasswordField(password)
             .clickOnLogInButtonOnFrame()
             .checkResultOfAuthorization(login);

}

}
