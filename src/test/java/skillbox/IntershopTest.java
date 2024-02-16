package skillbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


@Epic("Тесты на строку поиска сайта интернет-магазина")
@Feature("Проверка поиска товара по слову 'машина'")
@DisplayName("Тест для проверки работоспособности поисковой строки")
public class IntershopTest {

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    @Test
    @DisplayName("Проверка товара с именем 'машина'")
    void intershopTest(){
        setupBrowser();
        open("http://intershop.skillbox.ru/"); //переход на страницу сайта
        $(".search-field").setValue("Машина").pressEnter(); //поиск локатора строки поиска + ввод текста + клик enter
        //проверка видимости логотипа сайта
        Selenide.$(".site-logo").shouldBe(Condition.visible);
        //проверка загрузился ли список товаров и на 1-ом месте товар с именем Harry Potter
        $$(".products.columns-4 li").first().shouldHave(Condition.text("машина"));

    }

}
