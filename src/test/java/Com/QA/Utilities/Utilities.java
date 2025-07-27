package Com.QA.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class Utilities {

	public static void validate_Title(WebDriver driver,String title) {

		String Expected_Title = driver.getTitle();

		if(Expected_Title.equals(title)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	public static void validate_Url(WebDriver driver,String url) {

		String Expected_Title = driver.getTitle();

		if(Expected_Title.equals(url)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public static void Click_With_Fluent(WebDriver driver,String locator) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		WebElement button = wait.until(
				     new Function<WebDriver, WebElement>() {

						
						public WebElement apply(WebDriver t) {
							
							return driver.findElement(By.xpath(locator));
						}
					
				     
				     }
				  );
		
		button.click();
	}
	
	
	
}
