package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class OnboardingPage {
    public final SelenideElement pageTitle = $(xpath("/hierarchy//android.widget.Button"));

    @Step("Click on Skip onboarding button")
    public void clickOnSkipOnboardingButton() {
        pageTitle.click();
    }

}
