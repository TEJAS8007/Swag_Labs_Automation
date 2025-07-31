package Com.QA.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Com.QA.Utilities.Utilities;

public class Home_Page {

	WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver=driver;
	}

	By product_Names = By.xpath("//div[@class='inventory_item_name ']");
	By product_Info = By.xpath("//div[@class='inventory_item_desc']");
	By product_Price = By.xpath("//div[contains(@class,'inventory_item_price')]");

	By product_link = By.xpath("//a[@id='item_4_title_link']");

	public void Verify_Home_page_Title(String title) {

		String Expected_Title = Utilities.validate_Title(driver, title);
		System.out.println(Expected_Title);
	}

	public void Verify_Home_page_Url(String Url) {

		String Expected_Url = Utilities.validate_Url(driver, Url);
		System.out.println(Expected_Url);
	}

	public void verify_Product_Names() {

		List<WebElement> names = Utilities.Get_Multiple_Elements(driver, product_Names);

		for(WebElement ele :names) {

			String name = ele.getText();
			System.out.println(name);
		}
	}

	public void verify_Product_Info() {

		List<WebElement> infos = Utilities.Get_Multiple_Elements(driver, product_Info);

		Assert.assertEquals(infos.size(), 6);
		for(WebElement ele :infos) {

			String Info = ele.getText();
			System.out.println(Info);
		}
	}
	
	public void verify_Product_Price() {

		List<WebElement> Prices = Utilities.Get_Multiple_Elements(driver, product_Price);
    
		Assert.assertEquals(Prices.size(), 6);
		for(WebElement ele :Prices) {

			String price = ele.getText();
			System.out.println(price);
		}
	}
	
	public void click_On_Product(String Product_Name) {
		
		List<WebElement> names = Utilities.Get_Multiple_Elements(driver, product_Names);

		for(WebElement ele :names) {

			String name = ele.getText();
			
			if(name.equals(Product_Name)) {
				ele.click();
				break;
			}
		}
	}
}
