package tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;

@Owner("batrakov")
@Tag("Web")
public class ChangeTopics extends TestBase {

    @ParameterizedTest(name = "Change topic to {0}")
    @CsvFileSource(resources = "/topic.csv")
     void changeTopic(String topic) {
        step("Open main page of Reddit", () -> {
            mainPage.openPage();
        });
        step("", () -> {
            mainPage.clickOnTopicButton(topic);
        });
        step("Check result of test", () -> {
            popularPage.checkOpeningTopicPage(topic);
        });
    }
}
