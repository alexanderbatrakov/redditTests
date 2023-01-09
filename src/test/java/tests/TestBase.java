package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import config.ProjectCredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static support.Attach.*;
import static support.Attach.addVideo;

public class TestBase {
    public static String selenideUrl;
    public static MainPage mainPage = new MainPage();
    private static final ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    @BeforeAll
    static void beforeAll() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = projectConfig.getBrowserSize();
        Configuration.browser = projectConfig.getBrowser();
        Configuration.browserVersion = projectConfig.getBrowserVersion();
        Configuration.baseUrl = projectConfig.getBaseUrl();
        SelenideLogger.addListener("allure", new AllureSelenide());


            TestBase.selenideUrl = projectConfig.getSelenideUrl();
            Configuration.remote = TestBase.selenideUrl + "wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

    @AfterEach
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }

}
