package skillbox.work8_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Result {

    public SelenideElement resultTitle = $(".post-title");
    public SelenideElement resultItemName = $("tbody .woocommerce-table__product-name.product-name");
    public SelenideElement resultItemQuantity = $(".product-quantity");
    public SelenideElement resultEmailConfirm = $(".woocommerce-order-overview__email.email strong");
    public SelenideElement resultEmailCheck = $(".woocommerce-customer-details--email");
    public SelenideElement resultTown = $(".woocommerce-customer-details address");
    public SelenideElement resultTotal = $(".woocommerce-Price-amount.amount");
    public SelenideElement resultPaymentMethod = $("tfoot tr:nth-of-type(2) td");









}
