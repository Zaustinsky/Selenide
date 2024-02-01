package skillbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class IntershopTest {

    @Test
    void intershopTest(){
        open("https://intershop.skillbox.ru/"); //переход на страницу сайта
        $(".search-field").setValue("Машина").pressEnter(); //поиск локатора строки поиска + ввод текста + клик enter
        //проверка видимости логотипа сайта
        Selenide.$(".site-logo").shouldBe(Condition.visible);
        //проверка загрузился ли список товаров и на 1-ом месте товар с именем Harry Potter
        $$(".products.columns-4 li").first().shouldHave(Condition.text("машина"));

    }

}
