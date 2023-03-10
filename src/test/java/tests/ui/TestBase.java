package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.ui.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static support.Attach.*;

public class TestBase {
    public static String selenideUrl;
    public final MainPage mainPage = new MainPage();
    private static final ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = projectConfig.getBrowserSize();
        Configuration.baseUrl = projectConfig.getBaseUrl();
        SelenideLogger.addListener("allure", new AllureSelenide());

        if (projectConfig.getIsRemote()) {
            Configuration.browser = projectConfig.getBrowser();
            Configuration.browserVersion = projectConfig.getBrowserVersion();
            TestBase.selenideUrl = projectConfig.getSelenideUrl();
            Configuration.remote = TestBase.selenideUrl + "wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;

        }
    }

    @AfterEach
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
        closeWebDriver();
    }

}
