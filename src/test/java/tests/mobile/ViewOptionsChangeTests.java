package tests.mobile;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Owner("Batrakov")
@Tag("Mobile")
class ViewOptionsChangeTests extends BaseMobileTest {
    @Test
    @DisplayName("Change default view setting test")
    void changeDefaultViewTest() {
        String numberOfButton = "3";
        String nameOfButton = "Classic";
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnProfileButton()
                        .clickOnSettingsButton();
        settingPage.clickOnMainButtons(numberOfButton)
                .clickOnButtonSheet(nameOfButton)
                .checkSetUpOfOptions(numberOfButton,nameOfButton);
    }
    @Test
    @DisplayName("Change autoplay setting test")
    void changeAutoplayTest() {
        String numberOfButton = "4";
        String nameOfButton = "When on Wi-Fi";
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnProfileButton()
                .clickOnSettingsButton();
        settingPage.clickOnMainButtons(numberOfButton)
                .clickOnButtonSheet(nameOfButton)
                .checkSetUpOfOptions(numberOfButton,nameOfButton);
    }
    @Test
    @DisplayName("Change thumbnails setting test")
    void changeThumbnailsTest() {
        String numberOfButton = "5";
        String nameOfButton = "Never show";
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnProfileButton()
                .clickOnSettingsButton();
        settingPage.clickOnMainButtons(numberOfButton)
                .clickOnButtonSheet(nameOfButton)
                .checkSetUpOfOptions(numberOfButton,nameOfButton);
    }

}
