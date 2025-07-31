package Com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Com.QA.Utilities.Utilities;

public class CheckOut_Page {

	WebDriver driver;
	
	public CheckOut_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	By product_Name = By.xpath("//div[contains(@class,'inventory_item_name')]");
	By product_info = By.xpath("//div[contains(@class,'inventory_item_desc')]");
	By product_Price = By.xpath("//div[contains(@class,'inventory_item_price')]");
	By checkout_button = By.xpath("//button[contains(@id,'checkout' )  and  @name='checkout']");
	
	By First_Name = By.xpath("//input[contains(@name,'firstName')]");
	By Last_Name = By.xpath("//input[contains(@name,'lastName')]");
	By country_Code = By.xpath("//input[contains(@name,'postalCode')]");
	By Continu_Button = By.xpath("//input[contains(@name,'continue')]");
	
	public void Verify_Checkout_Page_Title(String title) {
		String Expected_title = Utilities.validate_Title(driver,title);
		System.out.println(Expected_title);
	}
	
	public void Verify_Checkout_Page_Url(String url) {
		String Expected_url = Utilities.validate_Url(driver, url);
		System.out.println(Expected_url);
	}
	
	public void Verify_Product_Name(String pName) {
		String name = driver.findElement(product_Name).getText();
		System.out.println(name);
		
		if(name.equals(pName)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	public void Verify_Product_Info(String pInfo) {
		String info = driver.findElement(product_info).getText();
		System.out.println(info);
		
		if(info.equals(pInfo)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void Verify_Product_Price(String pPrice) {
		String price = driver.findElement(product_Price).getText();
		System.out.println(price);
		
		if(price.equals(pPrice)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	public void click_on_Checkout() {
		Utilities.Click_With_Fluent(driver, checkout_button);
	}
	
	public void Sending_Address_Data(String fn,String ln,String po) {
		
		driver.findElement(First_Name).sendKeys(fn);
		driver.findElement(Last_Name).sendKeys(ln);
		driver.findElement(country_Code).sendKeys(po);
	}
	
	public void click_On_Continue() {
		Utilities.Click_With_Fluent(driver, Continu_Button);
	}
}
