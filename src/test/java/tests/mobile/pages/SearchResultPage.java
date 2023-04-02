package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SearchResultPage {
    public final SelenideElement sortButton = $(xpath("/hierarchy//android.view.View[1]/android.widget.TextView"));
    public final SelenideElement filterButton = $(xpath("/hierarchy//android.view.View[2]/android.widget.TextView"));

    @Step("Click on Time button")
    public SearchResultPage clickOnTimeButton() {
        filterButton.click();
        return this;
    }

    @Step("Click on Sort button")
    public SearchResultPage clickOnSortButton() {
        sortButton.click();
        return this;
    }

    @Step("Choose filter by Time")
    public SearchResultPage chooseTime(String time) {
        $(xpath("//android.widget.TextView[@text='" + time + "']")).click();
        return this;
    }

    @Step("Check of choosing correct sort filter")
    public SearchResultPage checkOfChoosingSort(String text) {
        sortButton.shouldHave(text(text));
        return this;
    }

    @Step("Check of choosing correct time filter")
    public SearchResultPage checkOfChoosingTime(String text) {
        filterButton.shouldHave(text(text));
        return this;
    }

    @Step("Choose filter by Sort")
    public SearchResultPage chooseSort(String sort) {
        $(xpath("//android.widget.TextView[@text='" + sort + "']")).click();
        return this;
    }


}

