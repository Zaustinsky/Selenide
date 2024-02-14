package skillbox.work8_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchArticle {

    SelenideElement searchInput = $("input.search-field");

    public void searchFor(String article){
        searchInput.setValue(article).pressEnter();
    }
}
