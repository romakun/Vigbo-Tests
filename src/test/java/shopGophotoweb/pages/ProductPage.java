package shopGophotoweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver.BaseForm;
import webdriver.elements.*;


public class ProductPage extends BaseForm {
    private Button btnAddToCart = new Button(By.xpath("//a[contains(@class,'autotest--addtocart')]"),"addToCartButton");
    //new Button(By.id("skuadd"), "addToCartButton");
    private  Button btnOutOfStock = new Button(By.xpath("//a[contains(text(),'Нет в наличии')]"),"Out of stock button");
    private  Button btnPreOrder = new Button(By.xpath("//a[contains(text(),\"Оформить заказ\")]"),"PreOrder button");
    private Label lblDiscount = new Label(By.xpath("//span[contains(@class,'autotest--product-price-discount')]"),"Discount label");
    //new Label(By.xpath("//span[@class='product-price-discount']"),"Discount label");
    private  Label lblOldPrice = new Label(By.xpath("//div[contains(@class,'autotest--price')]/span[contains(@class,'autotest--product-price-old')]"), "Old price");
    //new Label(By.xpath("//div[@class='price']/span[contains(@class,'product-price-old')]"),"Old price");
    private Label lblPrice= new Label(By.xpath("//div[contains(@class,'autotest--price')]/span[contains(@class,'autotest--product-price-min')]"),"Price label");
    //new Label(By.xpath("//div[@class='price']/span[contains(@class,'product-price-min')]"),"Price label");
    private  Label lblUnselectedItemError = new Label(By.xpath("//div[@class='error'][@data-prefix='Выберите']"),"Unselected item error");
    //private  Label lblUnselectedItemError=new Label(By.xpath("//div[@class='error'][@data-prefix='Выберите']"),"Unselected item error");
    //private  ElemetsList listOptions=new ElemetsList(By.xpath("//select[@class=\"options\"]"),"List options");
  //  private String selectValueLocator = "//div[contains(@class,'selectize-control')]";
    private String selectValueLocator2 = "//div[contains(@class,'selectize-dropdown-content')]/div[contains(text(), '%s')][not(@disabled)]";
    //"//select[@class='options']/option[.='%s'][not(@disabled)]";
    private Button btnGoToCatalogBreadecrumbs = new Button(By.xpath("//nav[contains(@class, 'autotest--shop-bread-crumbs')]/a[contains(text(),'магазин')]"),"shop bread crumbs");
    //new Button(By.xpath("//nav[contains(@class, 'shop-bread-crumbs')]/a[contains(text(),'магазин')]"),"shop bread crumbs");

    public ProductPage(){
        //super(By.xpath("//div[contains(@class,'page shop-product')]"),"Product Page");
        super(By.xpath("//div[contains(@class,'autotest--shop-product')]"),"Product Page");
    }



    public void addProductToCart() throws InterruptedException {
        btnAddToCart.click();
        Thread.sleep(2000);
            }




    public String  getAddButtonText(){
        System.out.println(btnAddToCart.getText());
        return btnAddToCart.getText();
    }
    public boolean isOutOfStockButtonDisplayed(){
        btnOutOfStock.waitForIsElementPresent();
        return btnOutOfStock.isPresent();
    }
    public void goToPreOrder(){
        btnPreOrder.waitForIsElementPresent();
        btnPreOrder.click();
    }
    public String getLblDiscount(){
        lblDiscount.waitForIsElementPresent();
        return lblDiscount.getText();
    }
    public String getLblOldPrice(){
        lblOldPrice.waitForIsElementPresent();
        return lblOldPrice.getText();
    }
    public String getLblPrice(){
        lblPrice.waitForIsElementPresent();
        return lblPrice.getText();
    }
    public boolean isLblUnselectedItemErrorDisplayed(){
        return lblUnselectedItemError.isPresent();
    }

   /* public void setSelectValueLocator(String value){
        Label selectValue = new Label(By.xpath(String.format(selectValueLocator,value)),"Value of select");
        selectValue.waitForIsElementPresent();
        selectValue.click();
    } */

    public void setSelectValueLocator(String selectName) throws InterruptedException{
       // Label selectos = new Label(By.xpath(selectValueLocator), "select dropdown");
       // selectos.click();
        Label selectos2 = new Label(By.xpath(String.format(selectValueLocator2, selectName)), "select select");
        selectos2.click();
        Thread.sleep(2000);

    }
/*
    public boolean isSelectOptionPresent(String optonValue){
        Label selectValue =new Label(By.xpath(String.format(selectValueLocator,optonValue)),"Value of select");
        return selectValue.isPresent();

    }*/
    public void goToCatalogByBreadecrumbs(){
        btnGoToCatalogBreadecrumbs.waitForIsElementPresent();
        btnGoToCatalogBreadecrumbs.click();
    }
}
