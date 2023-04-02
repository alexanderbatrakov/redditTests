package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.ui.pages.AuthorizationModalPage;
import tests.ui.pages.MainPage;
import tests.ui.pages.PopularPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static support.Attach.*;
import static tests.TestData.webConfig;

public class TestBase {
    public static String selenideUrl;
    public final MainPage mainPage = new MainPage();
    public final AuthorizationModalPage authorizationModalPage = new AuthorizationModalPage();
    public final PopularPage popularPage = new PopularPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.baseUrl = webConfig.getBaseUrl();
        SelenideLogger.addListener("allure", new AllureSelenide());

        if (webConfig.getIsRemote()) {
            Configuration.browser = webConfig.getBrowser();
            Configuration.browserVersion = webConfig.getBrowserVersion();
            TestBase.selenideUrl = webConfig.getSelenideUrl();
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
