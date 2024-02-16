package skillbox;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


@Epic("Тесты на каталог на сайте интернет-магазина")
@Feature("Каталоги книг и стиральных машин")
@DisplayName("Тесты для каталогов книг и стиральных машин")
public class Work7_4 {

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    @Test
    @DisplayName("Тесты для каталога книг на сайте интернет-магазина")
    public void task1() {

        //1. Напишите тесты для каталога книг на сайте интернет-магазина. Проверьте следующее:
        setupBrowser();
        open("http:intershop2.skillbox.ru/product-category/catalog/books/");
        $(".widget-title").shouldHave(text("Категории товаров"));
        //Количество категорий больше шести, но меньше либо равно 13.
        var collection = Selenide.$$(".product-categories > li").filterBy(tagName("li")).filterBy(visible)
                .shouldHave(CollectionCondition.sizeGreaterThan(6))
                .shouldHave(CollectionCondition.sizeLessThanOrEqual(13));
        //создание цикла для поиска и вывода в консоль элементов коллекции
        ElementsCollection elements = $$(".product-categories");
            for (var element:elements){
                System.out.println(element.getText());
            }
        //Первые три категории содержат текст «Без категории», «Бытовая техника», «Каталог».
        collection.first(3).shouldHave(texts("Без категории", "Бытовая техника", "Каталог"));
        //В списке присутствуют категории «Телефоны» и «Холодильники» в этом порядке.
        collection.shouldHave(containExactTextsCaseSensitive("Телефоны (6)", "Холодильники (5)"));
        //В последнем разделе («Электроника») 20 товаров.
        $(".product-categories > li:nth-of-type(13) a").click();
        sleep(1000);
        var collectionElectronic = Selenide.$$(".products.columns-4 > li").filterBy(tagName("li")).filterBy(visible)
                .shouldHave(CollectionCondition.size(12));
        $(".product-categories > li:nth-of-type(13) span").shouldHave(text("(20)"));

        sleep(5000);

    }

    @Test
    @DisplayName("Тест на страницу каталога стиральных машин в интернет-магазине")
    public void task2() {

        //2. (Необязательное усложнённое задание.) Напишите тест на страницу каталога стиральных машин в интернет-магазине,
        // который проверяет следующее: сумма товаров во всех категориях, li-элементы которых содержат css class “current-cat-parent”, равна 42.
        // Вы можете использовать как метод CollectionCondiion matchAll, так и обойтись без него — на ваш выбор.
        setupBrowser();
        open("http://intershop2.skillbox.ru/product-category/catalog/appliances/wash/");
        var a =$(".product-categories > li.current-cat-parent span:nth-of-type(1)").shouldHave(text("10"));
        var b =$(".product-categories > li:nth-of-type(3).current-cat-parent span").shouldHave(text("32"));

        sleep(5000);
    }
}
