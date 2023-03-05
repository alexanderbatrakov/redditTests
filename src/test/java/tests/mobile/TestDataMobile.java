package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.MobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import support.Attach;
import tests.mobile.pages.MainPage;
import tests.mobile.pages.OnboardingPage;
import tests.mobile.pages.SearchResultPage;
import tests.mobile.pages.SettingPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestDataMobile {
    @BeforeAll
    static void beforeAll() {
//        if (projectConfig.getEnvironment().equals("local")) {
//            Configuration.browser = MobileDriver.class.getName();
//        } else if (projectConfig.getEnvironment().equals("browserStack")) {
        Configuration.browser = MobileDriver.class.getName();
        // }
        Configuration.browserSize = null;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        //Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();

    }
OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    SettingPage settingPage = new SettingPage();

}
