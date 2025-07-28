package Com.QA.tests;

import org.testng.annotations.Test;

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
	
	@Test(priority = 2)
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
	
	@Test(priority = 3)
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
	
}
