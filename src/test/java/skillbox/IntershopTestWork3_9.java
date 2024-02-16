package skillbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


@Epic("Тесты для раздела Мой аккаунт")
@Feature("Проверка видимости и возможности переходов на странице")
@DisplayName("Проверки переходов по разделам меню")
public class IntershopTestWork3_9 {

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    //Задание 1. Тест на верность заголовков
    @Test
    @DisplayName("Проверка видимости элемента 'Мой аккаунт'")
    void intershopTestTitles(){
        //arrange
        setupBrowser();
        open("http://intershop2.skillbox.ru/");
        $(Selectors.byText("Мой аккаунт")).click();
        $(Selectors.byClassName("post-title")).shouldHave(Condition.visible);
//        $(Selectors.byClassName("custom-register-button")).click();

        sleep(5000);
    }

    //Задание 2. Тест на работоспособность переходов
    @Test
    @DisplayName("Проверка работоспособности переходов пунктов меню")
    void intershopTestTransitions(){
        //arrange
        setupBrowser();
        open("http://intershop2.skillbox.ru/");
        $(Selectors.byText("Мой аккаунт")).click();
        $(Selectors.byClassName("post-title")).shouldHave(Condition.visible);
        //переход на вкладку "Корзина"
        $("#menu-item-29 a").click();
        //проверка видимости класса с текстом "Корзина"
        $(Selectors.byClassName("current")).shouldHave(Condition.visible).shouldHave(Condition.text("Корзина"));
        $(Selectors.byText("Главная")).click();
        //проверка видимости подзаголовка с текстом "Распродажа" на главной странице
        $(Selectors.byCssSelector("#product1 h2.prod-title")).shouldHave(Condition.text("Распродажа"));

        sleep(5000);
    }

    //Задание 4. Практика работы с невидимыми элементами
    @Test
    @DisplayName("Проверка наличия невидимого элемента с id=finish на содежрание внутри текста «Телефон»")
    void unvisibleElementsTest(){
        //arrange
        setupBrowser();
        open("http://lm.skillbox.cc/qa_tester/module07/homework1/");
        //проверка невидимого элемента с id=finish на содежрание внутри текста «Телефон»
     // $(Selectors.byCssSelector("#finish")).shouldHave(Condition.text("Телефон")).shouldHave(Condition.visible);
        //проверка элемента с id=page_1 на содежрание внутри текста «Телефон»
        $(Selectors.byCssSelector("#page_1")).shouldHave(Condition.text("Телефон")).shouldHave(Condition.visible);

        sleep(5000);
    }
}
