package skillbox;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Work5_8 {

    @Test
    public void task1(){

        //1. Напишите тест на страницу заказа звонка:

        open("http://qa.skillbox.ru/module11/practice/feedbacksingle/");
        $("input[type='text']").click();
        //Подведите в выпадающем меню «Выберите день недели» мышку над числом 13 текущего месяца, которое будет обведено кружочком.
        //$(".datepicker__calendar.vdp-datepicker__calendar div> :nth-of-type(23)").hover();
        $(".datepicker__calendar.vdp-datepicker__calendar").$(byText("13")).hover();

        //Вместо проверки включите паузу в пять секунд, чтобы вам и проверяющему было видно, что операция удалась.
        sleep(5000);
    }

    @Test
    public void task2() {

        //2. Напишите тест на страницу:

        open("https://lm.skillbox.cc/qa_tester/module08/practice2/");
        //клик по комбобоксу "выбор языка"
        $(".module__input").click();
        sleep(1000);
        //выбор языка
        $(byText("Русский")).click();
        sleep(1000);
        //ввод имени
        $("[name=name]").setValue("Дмитрий");
        sleep(1000);
        //ввод фамилии
        $("[name=last__name]").setValue("Заустинский");
        sleep(1000);
        //клик по комбобоксу "год рождения"
        $(".module__inputs > div:nth-of-type(8) span").click();
        sleep(1000);
        // выбор из dropdown опции со значением 1982
        $("#sel > select").selectOptionByValue("1982");
        sleep(1000);
        //проставление чекбокса для выбора языка преподавания
        $(".module__inputs > div:nth-of-type(3) .jpn span").click();
        sleep(1000);
        //проставление чекбокса для выбора родного языка
        $(".module__inputs label.rus span").click();
        sleep(1000);
        //добавление суффикса "-сан" для фамилии
        $("[name=last__name]").append("-сан");
        sleep(1000);

    }

    @Test
    public void task3(){

        //3. Выполните задание по желанию. Напишите тест на страницу языковой школы:

        open("https://lm.skillbox.cc/qa_tester/module08/practice2/");
        //клик по комбобоксу "выбор языка"
        $(".module__input").click();
        sleep(1000);
        //Поменяйте язык на японский, а затем обратно на русский, используя byText.
        $(byText("Японский")).click();
        sleep(1000);
        //клик по комбобоксу "выбор языка"
        $(".module__input").click();
        sleep(1000);
        $(byText("ロシア語")).click();
        //Используйте задержку или проверку, чтобы убедиться в правильности результата.
        sleep(1000);
    }
}
