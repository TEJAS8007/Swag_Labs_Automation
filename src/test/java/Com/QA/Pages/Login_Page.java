package Com.QA.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Com.QA.Utilities.Utilities;

public class Login_Page {

	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	By userName = By.xpath("//input[starts-with(@id,'user-name')]");
	By passWord = By.xpath("//input[starts-with(@id,'password')]");
	By login_button = By.xpath("//input[contains(@id,'login-button')]");
	
	
	public void verify_Login_title(String title) {
		
		String Expected_title = Utilities.validate_Title(driver, title);
		System.out.println(Expected_title);
	}
	
	public void verify_Login_Url(String url) {
		
		String Expected_Url = Utilities.validate_Url(driver, url);
		System.out.println(Expected_Url);
	}
	
	public void login_Valid_userName(String un , String ps) {
		
		WebElement unName = driver.findElement(userName);
		unName.sendKeys(un);
		
		if(unName.getAttribute("value").equals(un)) {
			 assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		WebElement pass = driver.findElement(passWord);
		pass.sendKeys(ps);
		
		if(pass.getAttribute("value").equals(ps)) {
			 assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		Utilities.Click_With_Fluent(driver, login_button);
	}
}
