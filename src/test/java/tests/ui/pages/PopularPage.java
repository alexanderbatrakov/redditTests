package tests.ui.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PopularPage {
    public PopularPage checkOpeningPopularPage() {
        $(".otZ2uDhYTr1YmgF32ArRm").shouldHave(text("Popular posts"));
        return this;
    }
    public PopularPage checkOpeningTopicPage(String nameOfTopic) {
        $("._6HVKzUwnWtxEz7ZXIZ52z").shouldHave(text(nameOfTopic));
        return this;
    }
}
