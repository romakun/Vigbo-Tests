package shopGophotoweb.tests.promoCodes;

import shopGophotoweb.adminPages.AdminMainPage;
import shopGophotoweb.adminPages.LoginPage;
import shopGophotoweb.adminPages.OrdersPage;
import shopGophotoweb.adminPages.Utilites;
import shopGophotoweb.pages.*;
import webdriver.BaseTest;
import webdriver.Browser;

import static org.testng.Assert.assertTrue;


public class ST7a_006 extends BaseTest {

    @Override
    public void runTest() throws InterruptedException {

        logStep(1);
        CatalogPage catalogPage=new CatalogPage();
        catalogPage.goToProductPage("product1");

        ProductPage product1Page=new ProductPage();
        product1Page.addProductToCart();
        product1Page.goToCatalogByBreadecrumbs();

        logStep(2);
        catalogPage.goToProductPage("product2");
        ProductPage product2Page=new ProductPage();
        product2Page.addProductToCart();
        product2Page.goToCatalogByBreadecrumbs();

        logStep(3);
        catalogPage.goToProductPage("product5");
        ProductPage product5Page=new ProductPage();
        product5Page.addProductToCart();
        Menu.goToCart();

        logStep(4);
        CartPage cartPage=new CartPage();
        cartPage.fillInFields("test", "test", "tt@tt.tt");

        logStep(5);
        cartPage.selectDeliveryMethod(CartPage.DeliveryMethods.Курьер);
        logger.info("Expected result: total price = 8 100.20 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"8 100.20 pуб.");

        logStep(6);
        cartPage.applyPromoCode("6a");
        logger.info("Expected result: total price = 4 242 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"4 242 pуб.");

        logStep(7);
        cartPage.clickSubmit();
        SuccessPage successPage=new SuccessPage();
        assertTrue(successPage.isThanksForOrderMessageDisplayed());
        String orderNumber=successPage.getOrderNumber();
        logger.info("The order was completed");

        logStep(8);
        browser.navigate(Browser.getAdminPageUrl());
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        AdminMainPage adminMainPage = new AdminMainPage();
        adminMainPage.goToShop();

        logStep(9);
        Utilites.goToMenuName("МАГАЗИН");
        Utilites.goToSidebarItem(Utilites.SidebarItems.Продажи);
        Utilites.goToSidebarItem(Utilites.SidebarItems.Заказы);
        OrdersPage ordersPage=new OrdersPage();
        assertEquals(ordersPage.getOrderTotalPrice(orderNumber),"4 242 pуб.");
    }
}
