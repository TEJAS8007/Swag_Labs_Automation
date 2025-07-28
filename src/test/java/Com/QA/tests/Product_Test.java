package Com.QA.tests;

import org.testng.annotations.Test;

public class Product_Test extends Base_Test{

	
	@Test(priority = 1)
	void Login_Page_Test() {
	
		login.verify_Login_title(Data.getProperty("title"));
		login.verify_Login_Url(Data.getProperty("url"));
		login.login_Valid_userName(Data.getProperty("un"),Data.getProperty("ps"));
	}
	
	@Test(priority = 2)
	void Home_Page_Test() {
	
		home.Verify_Home_page_Title(Data.getProperty("title"));
		home.Verify_Home_page_Url(Data.getProperty("Home_url"));
		home.verify_Product_Names();
		home.verify_Product_Info();
		home.verify_Product_Price();
		home.click_On_Product(Data.getProperty("Product_Name"));
	}
	
	
}
