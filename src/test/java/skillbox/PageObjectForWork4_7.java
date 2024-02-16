package skillbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


@Epic("Локаторы для сайта интернет-магазина")
@Feature("Наличие локаторов и проверка на видимость")
@DisplayName("Проверка локаторов для страницы интернет-магазина")
public class PageObjectForWork4_7 {

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    @Test
    @DisplayName("проверка локаторов для страницы интернет-магазина")
    public void LocatorsForTask1() {

        //1. Напишите локаторы для элементов на странице интернет-магазина. Заканчивайте поиск командой проверки на видимость (shouldBe(visible)).

        setupBrowser();
        open("http://intershop2.skillbox.ru/");
        // По тегу: Footer (нижняя часть сайта).
        $("footer").shouldBe(Condition.visible);
        // По id: главное меню.
        $("#menu-item-26").shouldBe(Condition.visible);
        // По классу: элемент с контактной информацией в header (верхняя часть сайта).
        $(".before-top-header").shouldBe(Condition.visible);
        // Комбинированный CSS-локатор: кнопку поиска на странице, по тегу классу и атрибуту type одновременно.
        $("button.searchsubmit[type=submit]").shouldBe(Condition.visible);
        // Цепочку локаторов: элемент футер, внутри него элемент с id pages-2, внутри него элемент с текстом «Бонусная программа».
        $("footer").$("#pages-2").$(withText("Бонусная программа")).shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Проверка видимости локаторов для учебной страницы http://qajava.skillbox.ru/")
    public void LocatorsForTask2() {

        //2. Напишите локаторы для элементов на учебной странице http://qajava.skillbox.ru/. Заканчивайте поиск командой проверки на видимость (shouldBe(visible)).

        setupBrowser();
        open("http://qajava.skillbox.ru/");
        //По атрибуту со значением: элемент футера «О магазине».
        $("[test-info=about-us]").shouldHave(Condition.text("О магазине")).shouldBe(Condition.visible);
        //По тексту: меню пункта «Бестселлеры».
        $(".menu-main").$("li:nth-of-type(3)").$(byText("Бестселлеры")).shouldBe(Condition.visible);
        //По частичному тексту: меню пункта «Доставка и оплата».
        $(byText("Доставка и оплата")).shouldBe(Condition.visible);
        //Одним локатором элемент «Корзина»: линк, потомок элемента с классом menu-main, атрибут href у линка имеет значение checkout.html.
        $x("//ul[@class='menu-main']//a[@href='checkout.html']").closest(".menu-main").shouldBe(Condition.visible);
        //Родительский элемент для элемента с текстом «Атлант расправил плечи».
        $(byText("Атлант расправил плечи")).parent().shouldBe(Condition.visible);
        //Ближайший вверх по дереву элемент с классом book-info к элементу с текстом «Атлант расправил плечи».
        $(byText("Атлант расправил плечи")).closest(".book-info").shouldBe(Condition.visible);
        //Второй sibling к элементу прошлого задания (это будет книга «Ночь, когда огни погасли»).
        $(byText("Атлант расправил плечи")).closest(".book-info").sibling(1).shouldBe(Condition.visible);

    }

    @Test
    @DisplayName("нахождение локаторов с помощью XPATH")
    public void LocatorsForTask3() {

        //3. Задание по желанию на составление XPath:

        setupBrowser();
        open("http://qajava.skillbox.ru/module04/lesson2/");
        //Напишите XPath-локатор для элемента с тегом button, id=write-to-me и текстом «Напишите мне» на странице Отдам котят.
        //Заканчивайте поиск командой проверки на видимость (shouldBe(visible)).
        $x("//button[@id='write-to-me']").shouldBe(Condition.visible);
        //Как бы вы нашли этот же элемент, используя CSS Selector? Напишите код для поиска.
        $("#write-to-me").shouldBe(Condition.visible);

    }
}
