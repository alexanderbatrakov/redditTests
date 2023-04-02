package tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
@Owner("batrakov")
@Tag("Web")
public class ChangeFeedToPopular  extends TestBase{
    @Test
    @DisplayName("Change feed to popular")
    void changeFeedToPopular() {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("", () -> {
            mainPage.clickOnPopularButton();
        });
        step("Check result of test", () -> {
            popularPage.checkOpeningPopularPage();
        });
    }
}
