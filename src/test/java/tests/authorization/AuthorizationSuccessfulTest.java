package tests.authorization;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import tests.TestBase;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static tests.TestData.login;
import static tests.TestData.password;


public class AuthorizationSuccessfulTest extends TestBase {

    @Test
    void authorizationSuccessfulTest() {
        step("Open main page of Reddit", ()-> {
            mainPage.openPage();
        });
        step("Filling login and password fields, click on LogIn button", ()-> {
        mainPage.clickOnLogInButton()
                .fillingLoginField(login)
                .fillingPasswordField(password)
                .clickOnLogInButtonOnFrame();
        });
        step("Check result of test", ()-> {
            mainPage.checkResultOfAuthorization(login);
        });
    }

    @AfterAll
    static void afterAllAuthorizationSuccessfulTest() {
        getWebDriver();
        mainPage.logOut();

    }

}
