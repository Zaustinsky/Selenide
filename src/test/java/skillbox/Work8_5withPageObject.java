package skillbox;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import skillbox.work8_5.*;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Work8_5withPageObject {

    @BeforeAll
    public static void setupBrowser() {
        Configuration.browser = "firefox";
    }

    @Test
    public void buyWashingMachineTest(){

        setupBrowser();

        open("http://intershop2.skillbox.ru/register");
        //генерация нового пользователя
        var username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMhhHHmmss"));
        var email = username + "@ya.ru";
        new Registration().register(username, email, "Selenide123");
        new SearchArticle().searchFor("Стиральная машина");
        new ArticlesFound().addFirstArticleToBasket();
        new Menu().openMenu("Корзина");
        new Basket().basketItems.shouldHave(size(1));
        new Basket().firstArticleName.shouldHave(text("Стиральная машина"));
        new Basket().firstArticleQuantity.shouldHave(exactValue("1"));
        new Total().totalAmount.shouldHave(exactText("22990,00₽"));

        // 3. Продолжите тест из практики последнего видеоурока модуля, расширив сценарий.
        // Реализуйте тест сразу с использованием WidgetObject, промежуточные результаты сдавать на проверку не обязательно.
        new Total().goToPayButton.click();
        // Заполните все обязательные поля и нажмите «Оформить заказ».
        new Ordering().addOrderingList("Дмитрий", "Заустинский", "Надежденская, 5", "Минск",
                "Минская", "222161", "+37529777777", "Доставьте завтра");
        //Проверьте, что заказ получен.
        new Result().resultTitle.shouldHave(text("Заказ получен"));
        //Проверьте, что наименование товара и количество верны.
        new Result().resultItemName.shouldHave(text("Стиральная машина LG FH0C3ND, фронтальная, 6кг, 1000об/мин"));
        new Result().resultItemQuantity.shouldHave(text("× 1"));
        //Проверьте, что верен имейл, в подтверждении и в адресе для чека.
        new Result().resultEmailConfirm.shouldHave(text(email));
        new Result().resultEmailCheck.shouldHave(text(email));
        //Проверьте, что верен город получателя.
        new Result().resultTown.shouldHave(text("Минск"));
        //Проверьте, что верна итоговая сумма.
        new Result().resultTotal.shouldHave(text("22990,00₽"));
        //Проверьте, что верен способ оплаты.
        new Result().resultPaymentMethod.shouldHave(text("Оплата при доставке"));

        sleep(5000);
    }
}
