package shopGophotoweb.tests.promoCodes;

import org.testng.annotations.BeforeMethod;
import shopGophotoweb.adminPages.*;
import shopGophotoweb.pages.*;
import webdriver.BaseTest;
import webdriver.Browser;

import static org.testng.Assert.assertTrue;


public class ST7a_008 extends BaseTest {

    @BeforeMethod
    public void setPreconditions(){

        logStep();
        browser.navigate(Browser.getAdminPageUrl());
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        logStep(2);
        AdminMainPage adminMainPage = new AdminMainPage();
        adminMainPage.goToShop();

        AdminProductsPage adminProductsPage=new AdminProductsPage();
        Utilites.goToSidebarItem(Utilites.SidebarItems.Продажи);
        Utilites.goToSidebarItem(Utilites.SidebarItems.оплаты);

        logStep(3);
        PaymetsMethodsPage paymetsMethodsPage=new PaymetsMethodsPage();
        paymetsMethodsPage.unCheckAllMethods();
        paymetsMethodsPage.checkPaymentMethodVisible(PaymetsMethodsPage.PaymentMethods.МОЙ_ВИД_ОПЛАТЫ_С_КОМИССИЕЙ_1);

        logStep(4);
        Utilites.goToSidebarItem(Utilites.SidebarItems.доставки);
        DeliveryMethodsPage deliveryMethodsPage=new DeliveryMethodsPage();
        deliveryMethodsPage.unCheckAllMethods();
        deliveryMethodsPage.checkDeliveryMethodVisible(DeliveryMethodsPage.DeliveryMethods.Курьер);




    }

    @Override
    public void runTest() throws InterruptedException {

        logStep(1);
        CatalogPage catalogPage=new CatalogPage();
        catalogPage.goToProductPage("product1");

        ProductPage product1Page=new ProductPage();
        product1Page.addProductToCart();
        Menu.goToCart();

        logStep(2);
        CartPage cartPage=new CartPage();
        cartPage.fillInFields("test", "test", "tt@tt.tt");

        logStep(3);
        logger.info("Expected result: total price = 2 020 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"2 020 pуб.");

        logStep(4);
        cartPage.applyPromoCode("8a");
        logger.info("Expected result: total price = 979.70 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"979.70 pуб.");

        logStep(5);
        cartPage.setProductCount("product1","5");
        logger.info("Expected result: total price = 4 898.50 pуб.");
        logger.info("Actual result: total price = "+cartPage.getTotalPrice());
        assertEquals(cartPage.getTotalPrice(),"4 898.50 pуб.");

        logStep(6);
        cartPage.clickSubmit();
        SuccessPage successPage=new SuccessPage();
        assertTrue(successPage.isThanksForOrderMessageDisplayed());
        String orderNumber=successPage.getOrderNumber();
        logger.info("The order was completed");

        logStep(7);
        browser.navigate(Browser.getAdminPageUrl());
        AdminMainPage adminMainPage = new AdminMainPage();
        adminMainPage.goToShop();

        logStep(8);
        Utilites.goToMenuName("МАГАЗИН");
        Utilites.goToSidebarItem(Utilites.SidebarItems.Продажи);
        Utilites.goToSidebarItem(Utilites.SidebarItems.Заказы);
        OrdersPage ordersPage=new OrdersPage();
        assertEquals(ordersPage.getOrderTotalPrice(orderNumber),"4 898.50 pуб.");
    }
}
