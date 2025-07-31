package Com.QA.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.QA.Pages.Login_Page;
import Com.QA.Utilities.Driver_factory;
import Com.QA.Utilities.Excel_Data_Reader;

public class Data_Driven_Test {

	WebDriver driver;
	Login_Page login;
	Logger log;
	
	@BeforeMethod
	public void Set_up() {
		driver = Driver_factory.init_Driver();
		login = new Login_Page(driver);
		log = LogManager.getLogger(this.getClass());
	}
	
	@AfterMethod
	public void tear_Down() {
		
		if(driver!=null) { 
			driver.quit();
		}
	}
	
	@Test(dataProvider = "getLoginData")
	public void login_Test(String username,String password) {
		
		login.login_Valid_userName(username, password);
		log.info("Login Done For : "+username);
	}
	
	@DataProvider(name = "getLoginData")
	public Object[][] getLoginData() {
		
		Object[][] obj = Excel_Data_Reader.getLogin_Details();
		return obj;
	}
}
