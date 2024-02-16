package skillbox.work8_5;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Registration {

    //elements
    SelenideElement usernameInput = $("#reg_username");
    SelenideElement emailInput = $("#reg_email");
    SelenideElement passwordInput = $("#reg_password");
    SelenideElement registerButton = $("button[name='register']");

    //actions
    // @Step("регистрация пользователя")
    public void register(String username, String email, String password){
        usernameInput.setValue(username);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        registerButton.click();
    }
}
