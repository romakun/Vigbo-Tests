package shopGophotoweb.tests.promoCodes;

import shopGophotoweb.adminPages.AdminMainPage;
import shopGophotoweb.adminPages.LoginPage;
import shopGophotoweb.adminPages.OrdersPage;
import shopGophotoweb.adminPages.Utilites;
import shopGophotoweb.pages.*;
import webdriver.BaseTest;
import webdriver.Browser;

import static org.testng.Assert.assertTrue;


public class ST7a_010 extends BaseTest {

    @Override
    public void runTest() throws InterruptedException {

        logStep(1);
        CatalogPage catalogPage=new CatalogPage();
        catalogPage.goToProductPage("product1");

        ProductPage product1Page=new ProductPage();
        product1Page.addProductToCart();
        product1Page.goToCatalogByBreadecrumbs();

        logStep(2);
        catalogPage.goToProductPage("product3");
        ProductPage product3Page=new ProductPage();
        product3Page.addProductToCart();
        Menu.goToCart();

        logStep(3);
        CartPage cartPage=new CartPage();
        cartPage.fillInFields("test", "test", "tt@tt.tt");

        logStep(4);
        cartPage.setProductCount("product1","3");

        logStep(5);
        cartPage.setProductCount("product3","4");
        logger.info("Expected result: total price = 6 120.60 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"6 120.60 pуб.");

        logStep(6);
        cartPage.applyPromoCode("10a");
        assertTrue(cartPage.isPromocodeErrorDisplayed());

        logStep(7);
        cartPage.setProductCount("product1","4");
        logger.info("Expected result: total price = 7 140.70 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"7 140.70 pуб.");

        logStep(8);
        cartPage.applyPromoCode("10a");
        assertTrue(cartPage.isPromocodeErrorDisplayed());

        logStep(9);
        cartPage.setProductCount("product1","6");
        logger.info("Expected result: total price = 9 180.90 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"9 180.90 pуб.");

        logStep(10);
        cartPage.applyPromoCode("10a");
        logger.info("Expected result: total price = 7 171 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"7 171 pуб.");


        logStep(11);
        cartPage.clickSubmit();
        SuccessPage successPage=new SuccessPage();
        assertTrue(successPage.isThanksForOrderMessageDisplayed());
        String orderNumber=successPage.getOrderNumber();
        logger.info("The order was completed");

        logStep(12);
        browser.navigate(Browser.getAdminPageUrl());
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        AdminMainPage adminMainPage = new AdminMainPage();
        adminMainPage.goToShop();

        logStep(13);
        Utilites.goToMenuName("МАГАЗИН");
        Utilites.goToSidebarItem(Utilites.SidebarItems.Продажи);
        Utilites.goToSidebarItem(Utilites.SidebarItems.Заказы);
        OrdersPage ordersPage=new OrdersPage();
        assertEquals(ordersPage.getOrderTotalPrice(orderNumber),"7 171 pуб.");
    }
}
