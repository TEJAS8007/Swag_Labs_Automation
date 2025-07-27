package Com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {

	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	By userName = By.xpath("//input[starts-with(@id,'user-name')]");
	By passWord = By.xpath("//input[starts-with(@id,'password')]");
	By login_button = By.xpath("//input[contains(@id,'login-button')]");
}
