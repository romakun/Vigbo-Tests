package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Sergey on 20.03.2017.
 */
public class SuccessPage extends BaseForm {
    private Label lblThanksForOrderMessage=new Label(By.xpath("//p[contains(text(),'Спасибо за покупку!')]"), "thanksForOrderMessage");
    private Label lblThanksForPreOrderMessage=new Label(By.xpath(".//p[contains(text(),'Благодарим вас за оформление заказа!')]"), "thanksForPreOrderMessage");

    public SuccessPage(){
        super(By.className("shop-order-title"),"Success Page");
    }


    public boolean checkThanksForOrderMessage(){
        return lblThanksForOrderMessage.isPresent();
    }

    public boolean checkThanksForPreOrderMessage(){
        return lblThanksForPreOrderMessage.isPresent();
    }

    public String getOrdrerNumber(){
//	String textMessage=thanksForOrderMessage.toString(); //не преобразует, вот что выводит elements.TextBox@3a1d593e
        String textMessage=lblThanksForOrderMessage.getText();
        System.out.println("Сообщение о заказе "+textMessage);
        String orderNumber=textMessage.substring(textMessage.length()-6, textMessage.length());
        System.out.println("Номер заказа "+orderNumber);
        return orderNumber;

    }
}
