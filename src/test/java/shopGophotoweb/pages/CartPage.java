package shopGophotoweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.io.IOException;
import java.lang.Throwable;


public class CartPage extends BaseForm {
    private TextBox txbName = new TextBox(By.xpath("//label[contains(text(),'Имя')]/preceding-sibling::input"), "Name in order form");
    private TextBox txbLastame  = new TextBox(By.xpath("//label[contains(text(),'Фамилия')]/preceding-sibling::input"), "Lastname in order form");
    private TextBox txbEmail = new TextBox(By.xpath("//label[contains(text(),'Email')]/preceding-sibling::input"), "Email in order form");
    private Button btnSubmit = new Button(By.xpath("//*[contains(@class, 'autotest--form-btn-submit')]"), "Submit button");
    //  = new Button(By.name("data[btn-submit]"), "Submit button");
    private Label lblSkuQanityError = new Label(By.xpath(".//*[contains(@class,'autotest--product-count error-label')]"),"skuQanityError");
            // = new Label(By.xpath(".//div[@class='box-control__count js--product-count error-label']"),"skuQanityError");
    private Label lblTextBoxSkuCountError = new Label(By.xpath("//input[contains(@class,'autotest--sku-count error-field')]"));
                    // = new Label(By.xpath("//input[contains(@class,'box-number__input js--box-number__input textbox skuCount error-field')]"));
    private Label totalPriceSum = new Label(By.xpath(".//*[contains(@class, 'autotest--total-price-with-delivery')]"),"totalPriceSum");
                            //= new Label(By.xpath(".//*[@id='totalPriceWithDelivery']"),"totalPriceSum");
    private  Label formError=new Label(By.xpath("//div[contains(@class,\"error-input\")]"),"cart form error");
    private String locDeleteSomeProduct = "//span[contains(text(),'%s')]/../../../../div/a[contains(@class,'autotest--shopcart-delete-product')]";
            //="//a[contains(text(),'%s')]/../../td[contains(@class,'shop-cart-tbl-close')]/a";
    private String locCountSomeProduct = "//span[contains(text(),'%s')]/../../../../div/div/div/input[contains(@class,'autotest--sku-count')]";
                    //="//a[contains(text(),'%s')]/../../td[contains(@class,'shop-cart-tbl-center js--shop-cart skuCountCell')]/div/div/input";
    private Label lblPaymentError=new Label(By.id("shop-payment-error"),"Payment error");
    private Label lblDeliveryError=new Label(By.id("shop-delivery-error"),"Delivery error");
    private  Label lblPromoCodeError=new Label(By.id("shop-promo-msg"),"Promo code error ");
    private Label lblPromocode=new Label(By.id("shop-promo-link"),"Promo code link");
    private TextBox txbPromocode=new TextBox(By.id("shop-promo-code"),"Promo code textbox");
    private Button btnApplyPromocode=new Button(By.id("shop-apply-promo"),"Apply promo code button");
    private String locDeliveryPaymentMethod="//div[contains(text(),'%s')]";
    private  Label lblEmptyCart = new Label(By.xpath("//*[contains(@class, 'autotest--shopcart-empty-cart')]"),"Cart is empty message");
            //=new Label(By.xpath("//td[contains(text(),'Корзина пуста')]"),"Cart is empty message");
    public enum DeliveryMethods{Курьер,Самовывоз,Почта}
    public enum PaymentMethods{МОЙ_ВИД_ОПЛАТЫ_С_КОМИССИЕЙ_1,ЧЕРЕЗ_СИСТЕМУ_ЯНДЕКС_ДЕНЬГИ_С_КОММИСИЕЙ_3}
    private Label lblPaymentMethodUnavailable=new Label(By.xpath("//span[contains(text(),'Выбранный метод оплаты в данный момент не доступен')]"),"Error payment method unavailable");
    private Label lblDeliveryMethodUnavailable=new Label(By.xpath("//span[contains(text(),'Выбранный способ доставки в данный момент не доступен')]"),"Error payment method unavailable");
    private Label lblTotalOrderSumChanged=new Label(By.xpath("//span[contains(text(),'Стоимость заказа изменилась')]"),"Error total order sum was changed");
    private Button btnSuccess = new Button(By.xpath("//a[contains(@class,'autotest--shopcart-btn-success')]"),"Sucess button");
            //=new Button(By.xpath("//a[@class='btn btn-success']"),"Sucess button");
    private  Label lblShopBlockCart=new Label(By.xpath("//div[@class='shop-block-cart']"),"Block shop cart ");


    public CartPage(){
        super(By.xpath("//div[contains(@class,'md-shopcart__title')]"),"Cart Page");
    }


   public void setProductCount(String productName, String count) throws InterruptedException {
       TextBox txbProductCount=new TextBox(By.xpath(String.format(locCountSomeProduct,productName)),"product count input");

       txbProductCount.setText(count);
       Thread.sleep(3000);
       txbProductCount.sendKeys(Keys.ENTER);



   }


    public void fillInFields(String nameText, String lastNameText, String emailText)
    {
        txbName.setText(nameText);
        txbLastame.setText(lastNameText);
        txbEmail.setText(emailText);

    }
    public void clickSubmit()
    {
        btnSubmit.waitForIsElementPresent();
        btnSubmit.click();

    }
    public static void deleteProductFromCartButton(String productId) throws InterruptedException{

    //    BaseTest.GoToURL("/shop/cart/sku/"+productId+"/delete");


    }
    public boolean isSkuQanityErrorDisplayed(){

        lblSkuQanityError.waitForIsElementPresent();
        return lblSkuQanityError.isPresent();
    }

    public boolean isTextBoxSkuCountErrorDisplayed(){
        lblTextBoxSkuCountError.waitForIsElementPresent();
        return lblTextBoxSkuCountError.isPresent();
    }
    public boolean isFormErrorDisplayed(){
        System.out.println(formError.isPresent());
        formError.waitForIsElementPresent();
        return  formError.isPresent();
    }
    public String getTotalPrice() throws InterruptedException{
        Thread.sleep(2000);


        totalPriceSum.waitForIsElementPresent();

        return totalPriceSum.getText();
    }
    public void deleteSomeProduct(String productName){
        Button btnDeleteSomeProduct=new Button(By.xpath(String.format(locDeleteSomeProduct,productName)),"delete product button");
        btnDeleteSomeProduct.click();
        btnSuccess.click();
    }
    public boolean isPaymentErrorDisplayed(){
        lblPaymentError.waitForIsElementPresent();
        return lblPaymentError.isPresent();
    }
    public boolean isDeliveryErrorDisplayed(){
        lblDeliveryError.waitForIsElementPresent();
        return lblDeliveryError.isPresent();
    }
    public boolean isPromocodeErrorDisplayed(){
        lblPromoCodeError.waitForIsElementPresent();
        return lblPromoCodeError.isPresent();
    }
    public void waitUnblockCart() throws InterruptedException {
        if (lblShopBlockCart.isPresent())
            Thread.sleep(1000);

    }


        public void selectDeliveryMethod(DeliveryMethods deliveryMethodName) throws InterruptedException {
        Button btnDeliveryMethod=new Button(By.xpath(String.format(locDeliveryPaymentMethod,deliveryMethodName)),"Dilivery methods radiobatton");
        btnDeliveryMethod.click();
        Thread.sleep(1000);

    }
    public void selectPaymentMethod(PaymentMethods paymentMethodName) throws InterruptedException {
        Button btnDeliveryMethod=new Button(By.xpath(String.format(locDeliveryPaymentMethod,paymentMethodName)),"Payment methods radiobatton");
        btnDeliveryMethod.click();
        Thread.sleep(1000);

    }
    public boolean isDeliveryMethodDisplayed(DeliveryMethods deliveryMethodName) throws InterruptedException {
        Button btnDeliveryMethod=new Button(By.xpath(String.format(locDeliveryPaymentMethod,deliveryMethodName)),"Dilivery methods radiobatton");
        return btnDeliveryMethod.isPresent();
    }
    public boolean isPaymentMethodDisplayed(PaymentMethods paymentMethods) throws InterruptedException {
        Button btnDeliveryMethod=new Button(By.xpath(String.format(locDeliveryPaymentMethod,paymentMethods)),"Payment methods radiobatton");
        return btnDeliveryMethod.isPresent();
    }

    public boolean isEmptyCartMessageDisplayed(){
        lblEmptyCart.waitForIsElementPresent();
        return lblEmptyCart.isPresent();
    }

    public boolean isErrorPaymentMethodUnavailableDislayed(){
        lblPaymentMethodUnavailable.waitForIsElementPresent();
        return lblPaymentMethodUnavailable.isPresent();
    }
    public boolean isErrorDeliveryMethodUnavailableDislayed(){
        lblDeliveryMethodUnavailable.waitForIsElementPresent();
        return lblDeliveryMethodUnavailable.isPresent();
    }

    public boolean isErrorTotalOrderSumChangedDisplayed(){
        lblTotalOrderSumChanged.waitForIsElementPresent();
        return lblTotalOrderSumChanged.isPresent();
    }

    public void applyPromoCode(String promocod) throws InterruptedException {
        if(lblPromocode.isPresent()){
        lblPromocode.click();
        }
        txbPromocode.setText(promocod);
        btnApplyPromocode.click();
        Thread.sleep(1000);
    }


}
