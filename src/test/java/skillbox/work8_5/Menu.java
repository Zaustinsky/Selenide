package skillbox.work8_5;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Menu {

    SelenideElement menu = $("#menu-primary-menu");

    public void openMenu(String name){
        menu.find(Selectors.byText("Корзина")).click();
    }
}
