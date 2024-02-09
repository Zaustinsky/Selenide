package skillbox;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class Work6_9 {

    @BeforeAll
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    @Test
    public void task1() {

        //1. Напишите тесты с проверками для сайта интернет-магазина:
        //2. Для всех тестов из задания 1 уменьшите глобальный таймаут до 1 мс. Некоторые проверки, вероятно, начнут падать.
        setupBrowser();

        open("http://intershop2.skillbox.ru");
        // Проверьте видимость пункта «Оформление заказа» в поиске меню.
        $("#menu-primary-menu").$("a[href='http://intershop2.skillbox.ru/checkout/']").shouldBe(Condition.visible);
        sleep(1000);
        //Проверьте email в контактной информации — должно быть skillbox@skillbox.ru.
        $("#custom_html-2 > div a:nth-of-type(2)").shouldHave(text("skillbox@skillbox.ru"));
        sleep(1000);
        //В разделе сайта «Мой аккаунт» введите email в поле ввода и проверьте, что поле содержит символ @,
        $(Selectors.byText("Мой аккаунт")).click();
        var username = $("#username").setValue("test@skillbox.ru").shouldBe(Condition.visible);
        username.shouldHave(Condition.value("@"));
        sleep(1000);
        //а поле «Пароль» пустое.
        $("#password").shouldHave(Condition.empty);
        sleep(1000);
        //Проверьте, что чекбокс «Запомнить меня» не включён и disabled.
        $("#rememberme").shouldHave(Condition.disabled);
        sleep(1000);
        //В разделе сайта «Мой аккаунт» проверьте, что кнопка «Войти» содержит класс woocommerce-button.
        $(".woocommerce-button").shouldHave(Condition.visible);
        sleep(1000);
        //Наведите мышку на кнопку «Зарегистрироваться», убедитесь, что цвет кнопки красный,
        var colorButton = $(".custom-register-button").scrollTo().hover()
                .shouldHave(Condition.cssValue("background-color", "rgb(226, 69, 69)"));
        //затем уберите мышку
        username.scrollTo();
        //и убедитесь, что цвет кнопки белый.
        colorButton.shouldHave(Condition.cssValue("background-color", "rgb(255, 255, 255)"));
        //В разделе сайта «Мой аккаунт» убедитесь, что на странице есть hidden input поле с именем _wp_http_referer.
        //Проверьте, что атрибут value у поля — /my-account/.
        $("input[type='hidden']").$("[name='_wp_http_referer']").$("[value='/my-account/']").shouldNotHave(Condition.visible);
    }


    @Test
    public void task3() {
        //3. Напишите тесты с проверками для сайта интернет-магазина:

        setupBrowser();
        open("http://intershop2.skillbox.ru");
        //поищите APPLE в списке товаров;
        $(".search-form").$("input").setValue("APPLE").pressEnter();
        //убедитесь, что в результатах поиска есть iPad или Watch.
        $(".products.columns-4 > li:nth-of-type(1) > div:nth-of-type(2) > a >h3").shouldHave(text("Watch"));
        $(".products.columns-4 > li:nth-of-type(2) > div:nth-of-type(2) > a >h3").shouldHave(text("iPad"));


        sleep(5000);
    }
}
