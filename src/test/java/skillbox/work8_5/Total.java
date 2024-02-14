package skillbox.work8_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Total {

    public SelenideElement totalAmount = $("#primary div.cart_totals tr td[data-title=Сумма]");
    public SelenideElement goToPayButton = $(".checkout-button.button.alt.wc-forward");
}
