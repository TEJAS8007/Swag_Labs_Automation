package Com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Com.QA.Utilities.Utilities;


public class Cart_Page {

	WebDriver driver;

	public Cart_Page(WebDriver driver) {
		this.driver=driver;
	}

	By product_Name = By.xpath("//div[contains(@class,'inventory_details_desc_container')]/child ::div[1]");
	By product_Info = By.xpath("//div[contains(@class,'inventory_details_desc_container')]/child ::div[2]");
	By product_price = By.xpath("//div[contains(@class,'inventory_details_desc_container')]/child ::div[3]");
	By Add_To_Cart = By.xpath("//div[contains(@class,'inventory_details_desc_container')]/child ::div[3]/following ::button");
	By cart_Button = By.xpath("//div[@id='shopping_cart_container']");

	public void Verify_Cart_Page_Title(String title) {
		String Expected_title = Utilities.validate_Title(driver, title);
		System.out.println(Expected_title);
	}

	public void Verify_Cart_Page_Url(String Url) {
		String Expected_url = Utilities.validate_Url(driver, Url);
		System.out.println(Expected_url);
	}

	public void Verify_Product_Name(String cart_product) {

		String name = driver.findElement(product_Name).getText();
		System.out.println(name);
		
		if(name.equals(cart_product)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	public void Verify_Product_Info(String cart_Info) {

		String info = driver.findElement(product_Info).getText();
		System.out.println(info);
		
		if(info.equals(cart_Info)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void Verify_Product_price(String cart_Price) {

		String price = driver.findElement(product_price).getText();
		System.out.println(price);
		
		if(price.equals(cart_Price)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void click_On_Add_To_Cart() {

		Utilities.Click_With_Fluent(driver, Add_To_Cart);
	}
	
	public void click_On_Cart() {

		Utilities.Click_With_Fluent(driver, cart_Button);
		
	}
}
