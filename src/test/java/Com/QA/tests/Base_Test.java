package Com.QA.tests;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	public WebDriver driver;
	public Login_Page login;
	public Home_Page home;
	public Cart_Page cart;
	public CheckOut_Page checkout;
	public Payment_Page payment;
	public Properties Data;
	public Logger log;

	@BeforeTest
	public void set_up() {
	    log = LogManager.getLogger(this.getClass());
	    Data = Property_Reader.login_prop();
	    driver = Driver_factory.init_Driver();
	    Event_Listeners.driver = driver;
	    login = new Login_Page(driver);
	    home = new Home_Page(driver);
	    cart = new Cart_Page(driver);
	    checkout = new CheckOut_Page(driver);
	    payment = new Payment_Page(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    log.debug("----------Before Method Started-----------");
	}

	@AfterTest
	public void tear_Down() {
	    log.debug("----------After Method Ended-----------");
	    if (driver != null) {
	        driver.quit();
	    }
	}

}
