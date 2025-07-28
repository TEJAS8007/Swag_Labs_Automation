package Com.QA.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Com.QA.Pages.Home_Page;
import Com.QA.Pages.Login_Page;
import Com.QA.Utilities.Driver_factory;
import Com.QA.Utilities.Property_Reader;

public class Base_Test {

	WebDriver driver;
	Login_Page login;
	Home_Page home;
	Properties Data;
	
	@BeforeTest
	public void set_up() {
		Data = Property_Reader.login_prop();
		driver = Driver_factory.init_Driver();
		login = new Login_Page(driver);
		home = new  Home_Page(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	void tear_Down() {
		
		if(driver!=null) {
			driver.quit();
		}
	}
}
