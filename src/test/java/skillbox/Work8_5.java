package skillbox;
import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("Заметки")
@Feature("Автоматизация сценария для сайта Заметки")
@DisplayName("Создание заметок для календаря")
public class Work8_5 {

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Автоматизация сценария для сайта Заметки")
    @Description(value = """
            1. Проверка, что на панели справа существует одна заметка, созданная сегодня
            2. Добавка ещё одной заметки (заголовок и текст) из центральной панели
            3. Проверка добавленной заметки в верхней части панели справа
            4. Добавка ещё одной заметки, вызвав функцию «Добавить заметку» из правой панели
            5. Проверка добавленной заметки в верхней части панели справа
            6. Переход в меню со статистикой
            7. Проверка, что в календаре отмечено, что сегодня создано три заметки
            8. Проверка, что за вчера создана одна заметка""")
    public void testForWork1(){

        //1. Автоматизируйте сценарий, описанный ниже, для сайта Заметки. Сначала напишите тест, как делали это в прошлых модулях,
        // не используя паттерн WidgetObject. После в отдельном классе реализуйте этот же сценарий с использованием WidgetObject.
        // a. Проверьте, что на панели справа существует одна заметка, созданная сегодня.
        open("http://qa.skillbox.ru/module15/bignotes/#/");
        Selenide.$$(".vb-content").first().shouldHave(text("15 ФЕВРАЛЯ 2024"));
        // b. Добавьте ещё одну заметку (заголовок и текст) из центральной панели.
        $("input[placeholder='Введите заголовок']").setValue("Магазин");
        $("textarea[placeholder='Введите основной текст']").setValue("Завтра в 17.00");
        $(".baseButton.pageCreate__baseButton").click();
        // c. Проверьте, что ваша заметка верхняя в панели справа.
        Selenide.$$(".vb-content").first().shouldHave(text("Магазин"));
        // d. Добавьте ещё одну заметку, вызвав функцию «Добавить заметку» из правой панели.
        $("button.pageCreate__sidebarHeaderAdd use").click();
        $(".popup__content input[placeholder='Введите заголовок']").setValue("Книги");
        $(".popup__content textarea[placeholder='Введите основной текст']").setValue("Найти книгу о любви");
        $(".popup__content button").click();
        // e. Проверьте, что новая заметка верхняя в панели справа.
        Selenide.$$(".vb-content").first().shouldHave(text("Книги"));
        // f. Перейдите в меню со статистикой.
        $("a[href='/module15/bignotes/#/statistic']").click();
        // g. Убедитесь, что в календаре отмечено, что сегодня создано три заметки.
        Selenide.$$(".baseCalendar__count").shouldHave(CollectionCondition.size(2));
        // h. Убедитесь, что за вчера создана одна заметка.
        // (Будем считать, что сегодня не первый день месяца, так что кодировать логику теста по смене месяца не надо.
        // И запускать тест в первый день месяца — тоже :) Почему — читайте в описании следующего необязательного задания).
        $$(".cell.day .baseCalendar__text .baseCalendar__count").shouldHave(CollectionCondition.size(2));





        sleep(5000);

    }
}
