package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.openqa.selenium.By.id;

public class MainPage {
    public final SelenideElement searchButton = $(id("com.reddit.frontpage:id/feed_control_search_icon"));
    public final SelenideElement searchField = $(id("com.reddit.frontpage:id/search"));
    public final SelenideElement settingsButton = $(id("com.reddit.frontpage:id/drawer_nav_settings"));
    public final SelenideElement profileButton = $(id("com.reddit.frontpage:id/inner_user_icon"));

    @Step("Click on Skip onboarding button")
    public MainPage clickOnSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Paste searching text and search")
    public MainPage pasteSearchingTextAndSearch() {
        searchField.sendKeys("test");
        executeJavaScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
        return this;
    }

    @Step("Click on settings button")
    public MainPage clickOnSettingsButton() {
        settingsButton.click();
        return this;
    }

    @Step("Click on profile button")
    public MainPage clickOnProfileButton() {
        profileButton.click();
        return this;
    }

}
