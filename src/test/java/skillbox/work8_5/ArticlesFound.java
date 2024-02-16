package skillbox.work8_5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ArticlesFound {

    public ElementsCollection articles = $$("#primary .wc-products li");
    SelenideElement articles1 = $("#primary .wc-products li");

    public void addFirstArticleToBasket(){
        articles.first().$(".price-cart a").click();
    }
}
