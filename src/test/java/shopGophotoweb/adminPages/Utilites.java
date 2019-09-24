package shopGophotoweb.adminPages;

import org.openqa.selenium.By;
import webdriver.elements.Button;
import webdriver.elements.Label;


public class Utilites {
    private static String locMenuItem="//ul[@class='clearfix']/li/a/span[contains(text(),'%s')]";
    private static String locSidear="//a[contains(text(),'%s')]";
    private static Button btnLogout=new Button(By.xpath("//a[contains(@href,'logout')]/span[contains(text(),'Выход')]"),"Logout button");
    private Label lblConfirmBlock=new Label(By.xpath("//div[@class='confirmation-admin-message-cover']"),"confirm block ");

    public enum SidebarItems{Каталог, Товары, Категории, Лэйблы, Продажи, Заказы, Промо, оплаты, доставки, Оформление, предзаказа, Настройки, Общие}

    public static void goToMenuName(String menuItemName) {
        Button btnMenuItem=new Button(By.xpath(String.format(locMenuItem,menuItemName)),"Menu item with name"+menuItemName);
        btnMenuItem.waitForIsElementPresent();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        btnMenuItem.click();
    }

    public static void goToSidebarItem(SidebarItems itemName){
        Button btnSidebar=new Button(By.xpath(String.format(locSidear,itemName)),"Sidebar item");
        btnSidebar.waitForIsElementPresent();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnSidebar.click();
    }
    public static void logout(){
        btnLogout.waitForIsElementPresent();
        btnLogout.click();
    }

}
