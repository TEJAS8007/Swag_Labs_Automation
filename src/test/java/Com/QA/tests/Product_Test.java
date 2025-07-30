package Com.QA.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.QA.Utilities.Excel_Data_Reader;

public class Product_Test extends Base_Test{

	
	@Test(priority = 1)
	void Login_Page_Test() {
	
		login.verify_Login_title(Data.getProperty("title"));
		log.info("Login Page title verified....");
		login.verify_Login_Url(Data.getProperty("url"));
		log.info("Login Page Url verified....");
		login.login_Valid_userName(Data.getProperty("un"),Data.getProperty("ps"));
		log.info("Login Complete....");
	}
	
	@Test(priority = 2,dependsOnMethods = "Login_Page_Test()")
	void Home_Page_Test() {
	
		home.Verify_Home_page_Title(Data.getProperty("title"));
		log.info("Home Page title verified....");
		home.Verify_Home_page_Url(Data.getProperty("Home_url"));
		log.info("Home Page Url verified....");
		home.verify_Product_Names();
		log.info("Home Page Product Names verified....");
		home.verify_Product_Info();
		log.info("Home Page Product Infos verified....");
		home.verify_Product_Price();
		log.info("Home Page Product Prices verified....");
		home.click_On_Product(Data.getProperty("Product_Name"));
		log.info("Home Page Product Selected....");
	}
	
	@Test(priority = 3,dependsOnMethods = "Home_Page_Test()")
	public void Cart_Page_Test() {
		cart.Verify_Cart_Page_Title(Data.getProperty("title"));
		log.info("Cart Page title verified....");
		cart.Verify_Cart_Page_Url(Data.getProperty("cart_url"));
		log.info("Cart Page url verified....");
		cart.Verify_Product_Name(Data.getProperty("Product_Name"));
		log.info("Cart Page Product Name verified....");
		cart.Verify_Product_Info(Data.getProperty("cart_info"));
		log.info("Cart Page Product Info verified....");
		cart.Verify_Product_price(Data.getProperty("cart_price"));
		log.info("Cart Page Product Price verified....");
		cart.click_On_Add_To_Cart();
		log.info("Cart Page Clicked On Add To Cart....");
		cart.click_On_Cart();
		log.info("Cart Page Clicked Cart....");
	}
	
	@Test(priority = 4, dataProvider = "getData()",dependsOnMethods = "Cart_Page_Test()")
	public void Checkout_Page_Test(String fn,String ln,String po) {
		
		checkout.Verify_Checkout_Page_Title(Data.getProperty("title"));
		log.info("Checkout Page Title Verified.....");
		checkout.Verify_Checkout_Page_Url(Data.getProperty("checkout_url"));
		log.info("Checkout Page Url Verified.....");
		checkout.Verify_Product_Name();
		log.info("Checkout Product Name Verified.....");
		checkout.Verify_Product_Info();
		log.info("Checkout Product Info Verified.....");
		checkout.Verify_Product_Price();
		log.info("Checkout Product Price Verified.....");
		checkout.click_on_Checkout();
		log.info("Clicked On Checkout.....");
		
		
		checkout.Sending_Address_Data(fn, ln, po);
		log.info("Address details Sent....");
		checkout.click_On_Continue();
		log.info("Clicked On Continue Button.....");
		
	}
	
	@Test(priority = 5,dependsOnMethods = "Checkout_Page_Test()")
	public void payment_page_Test() {
		
		payment.verify_Payment_page_Title(Data.getProperty("title"));
		log.info("Payment Page Title Verified.....");
		payment.verify_Payment_page_url(Data.getProperty("payment_url"));
		log.info("Payment Page Url Verified.....");
		payment.verify_Product_Name(Data.getProperty("Product_Name"));
		log.info("Payment Product Name Verified.....");
		payment.verify_Product_info(Data.getProperty("cart_info"));
		log.info("Payment Product Info Verified.....");
		payment.verify_Product_price(Data.getProperty("cart_price"));
		log.info("Payment Product Price Verified.....");
		payment.verify_payment_info(Data.getProperty("payment_info"));
		log.info("Payment Page Payment Info Verified.....");
		payment.verify_shipping_info(Data.getProperty("shipping_info"));
		log.info("Payment Shipping Info Verified.....");
		payment.verify_total_price(Data.getProperty("total_price"));
		log.info("Payment Page Total Price Verified.....");
		payment.click_on_findsh_button();
		log.info("Payment Clicked on Finish.....");
	}
	
	@DataProvider(name = "getData()")
	public Object[][] getData() {
		
		Object[][] obj = Excel_Data_Reader.getExcelData();
		return obj;
	}
}
