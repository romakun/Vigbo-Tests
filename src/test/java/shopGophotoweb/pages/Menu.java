package shopGophotoweb.pages;

import org.openqa.selenium.By;
import webdriver.elements.Button;
import java.io.IOException;


public class Menu {
    private static Button btnShop=new Button(By.xpath("//a[contains(text(),'МАГАЗИН')]"),"Go to shop catalog button");
    private static Button btnGoToCart = new Button(By.xpath("//a[@data-id='shop-cart-widget']"),"goToCart");

    public static void goToShopCatalog(){
        btnShop.waitForIsElementPresent();
        btnShop.click();
    }

    public static void goToCart() throws InterruptedException {
        btnGoToCart.click();
        CartPage cartPage = new CartPage();
        cartPage.waitUnblockCart();

    }

}
