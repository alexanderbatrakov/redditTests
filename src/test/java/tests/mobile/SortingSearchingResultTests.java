package tests.mobile;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Owner("Batrakov")
@Tag("Mobile")
class SortingSearchingResultTests extends BaseMobileTest {
    @Test
    @DisplayName("Filter search result by: most relevant and all time test")
    void mostRelevantAndAllTimeTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Most relevant")
                .clickOnTimeButton()
                .chooseTime("All time")
                .checkOfChoosingSort("Sort")
                .checkOfChoosingTime("Time");
    }

    @Test
    @DisplayName("Filter search result by: most relevant and past year test")
    void mostRelevantAndPastYearTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Most relevant")
                .clickOnTimeButton()
                .chooseTime("Past year")
                .checkOfChoosingSort("Sort")
                .checkOfChoosingTime("Past year");
    }

    @Test
    @DisplayName("Filter search result by: top and past month test")
    void topAndPastMonthTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Top")
                .clickOnTimeButton()
                .chooseTime("Past month")
                .checkOfChoosingSort("Top")
                .checkOfChoosingTime("Past month");
    }

    @Test
    @DisplayName("Filter search result by: top and past week test")
    void topAndPastWeekTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Top")
                .clickOnTimeButton()
                .chooseTime("Past week")
                .checkOfChoosingSort("Top")
                .checkOfChoosingTime("Past week");
    }
    @Test
    @DisplayName("Filter search result by: comment count and past 24 hours test")
    void commentCountAndPast24HoursTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Comment count")
                .clickOnTimeButton()
                .chooseTime("Past 24 hours")
                .checkOfChoosingSort("Comment count")
                .checkOfChoosingTime("Past 24 hours");
    }

    @Test
    @DisplayName("Filter search result by: comment count and past hour test")
    void commentCountAndPastHourTest() {
        onboardingPage.clickOnSkipOnboardingButton();
        mainPage.clickOnSearchButton()
                .pasteSearchingTextAndSearch();
        searchResultPage.clickOnSortButton()
                .chooseSort("Comment count")
                .clickOnTimeButton()
                .chooseTime("Past hour")
                .checkOfChoosingSort("Comment count")
                .checkOfChoosingTime("Past hour");
    }

}
