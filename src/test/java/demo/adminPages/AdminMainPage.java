package demo.adminPages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Sergey on 02.04.2017.
 */
public class AdminMainPage extends BaseForm {

    private Button btnShop=new Button(By.xpath("//span[contains (text(),\"МАГАЗИН\")]/.."),"Shop button");

    public AdminMainPage(){super(By.id("btnAddPage"),"Main site admin page");}

    public void goToShop(){
        btnShop.click();
    }
}
