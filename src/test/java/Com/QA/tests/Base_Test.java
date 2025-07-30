package Com.QA.tests;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Com.QA.Pages.Cart_Page;
import Com.QA.Pages.CheckOut_Page;
import Com.QA.Pages.Home_Page;
import Com.QA.Pages.Login_Page;
import Com.QA.Pages.Payment_Page;
import Com.QA.Utilities.Driver_factory;
import Com.QA.Utilities.Event_Listeners;
import Com.QA.Utilities.Property_Reader;

public class Base_Test {

	WebDriver driver;
	Login_Page login;
	Home_Page home;
	Cart_Page cart;
	CheckOut_Page checkout;
	Payment_Page payment;
	Properties Data;
	Logger log;

	@BeforeTest
	public void set_up() {
		log = LogManager.getLogger(this.getClass());
		Data = Property_Reader.login_prop();
		driver = Driver_factory.init_Driver();
		Event_Listeners.driver=driver;
		login = new Login_Page(driver);
		home = new Home_Page(driver);
		cart = new Cart_Page(driver);
		checkout = new CheckOut_Page(driver);
		payment = new Payment_Page(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.debug("----------Before Test SetUp Started-----------");
	}

	@AfterTest
	void tear_Down() {
		log.debug("----------After Test SetUp Ended-----------");
		if(driver!=null) {
			driver.quit();
		}
	}
}
