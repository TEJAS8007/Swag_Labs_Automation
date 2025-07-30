package Com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Com.QA.Utilities.Utilities;

public class Payment_Page {

	WebDriver driver;
	
	public Payment_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	By product_Name = By.xpath("//div[contains(@class,'inventory_item_name')]");
	By product_info = By.xpath("//div[contains(@class,'inventory_item_desc')]");
	By product_price = By.xpath("//div[contains(@class,'inventory_item_price')]");
	
	By payment_info = By.xpath("//div[contains(@class,'summary_value_label') and starts-with(@data-test,'pa')]");
	By shipping_info = By.xpath("//div[contains(@class,'summary_value_label') and starts-with(@data-test,'sh')]");
	By total_price = By.xpath("//div[contains(@class,'summary_total_label') and starts-with(@data-test,'to')]");
	By finish_button = By.xpath("//button[starts-with(@id,'fin')]");
	
	
	public void verify_Payment_page_Title(String title) {
		String Expected_Title = Utilities.validate_Title(driver, title);
		System.out.println(Expected_Title);
	}
	
	public void verify_Payment_page_url(String url) {
		String Expected_url = Utilities.validate_Url(driver, url);
		System.out.println(Expected_url);
	}
	
	public void verify_Product_Name(String product_name) {
		String name = driver.findElement(product_Name).getText();
		System.out.println(name);
		
		if(name.equals(product_name)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	public void verify_Product_info(String product_information) {
		String info = driver.findElement(product_info).getText();
		System.out.println(info);
		
		if(info.equals(product_information)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	public void verify_Product_price(String Pro_price) {
		String price = driver.findElement(product_price).getText();
		System.out.println(price);
		
		if(price.equals(Pro_price)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void verify_payment_info(String paid_info) {
		String pay_info = driver.findElement(payment_info).getText();
		System.out.println(pay_info);
		
		if(pay_info.equals(paid_info)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void verify_shipping_info(String info) {
		String ship_info = driver.findElement(shipping_info).getText();
		System.out.println(ship_info);
		
		if(ship_info.equals(info)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void verify_total_price(String Total_Price) {
		String to_price = driver.findElement(total_price).getText();
		System.out.println(to_price);
		
		if(to_price.equals(Total_Price)) {
			Assert.assertTrue(true);
		}  
		else {
		    Assert.assertTrue(false);	
		}
	}
	
	public void click_on_findsh_button() {
		Utilities.Click_With_Fluent(driver, finish_button);
	}
}
