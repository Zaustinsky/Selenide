package skillbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class IntershopTestWork3_9 {

    //Задание 1. Тест на верность заголовков
    @Test
    void intershopTestTitles(){
        //arrange
        open("https://intershop2.skillbox.ru/");
        $(Selectors.byText("Мой аккаунт")).click();
        $(Selectors.byClassName("post-title")).shouldHave(Condition.visible);
//        $(Selectors.byClassName("custom-register-button")).click();

        sleep(5000);
    }

    //Задание 2. Тест на работоспособность переходов
    @Test
    void intershopTestTransitions(){
        //arrange
        open("https://intershop2.skillbox.ru/");
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
    void unvisibleElementsTest(){
        //arrange
        open("https://lm.skillbox.cc/qa_tester/module07/homework1/");
        //проверка невидимого элемента с id=finish на содежрание внутри текста «Телефон»
     // $(Selectors.byCssSelector("#finish")).shouldHave(Condition.text("Телефон")).shouldHave(Condition.visible);
        //проверка элемента с id=page_1 на содежрание внутри текста «Телефон»
        $(Selectors.byCssSelector("#page_1")).shouldHave(Condition.text("Телефон")).shouldHave(Condition.visible);

        sleep(5000);
    }
}
