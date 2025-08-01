package Com.QA.Utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {

	public static String validate_Title(WebDriver driver,String title) {

		String Expected_Title = driver.getTitle();

		if(Expected_Title.equals(title)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		return Expected_Title;
	}

	public static String validate_Url(WebDriver driver,String url) {

		String Expected_Url = driver.getCurrentUrl();

		if(Expected_Url.equals(url)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		return Expected_Url;
	}

	public static void Click_With_Fluent(WebDriver driver,By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement button = wait.until(

				ExpectedConditions.elementToBeClickable(locator)
				);

		button.click();
	}


	public static WebElement Find_Element_With_Fluent(final WebDriver driver,final By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		return wait.until(
				new Function<WebDriver, WebElement>() {


					public WebElement apply(WebDriver t) {

						return driver.findElement(locator);
					}


				}
				);

	}

	public static List<WebElement> Get_Multiple_Elements(WebDriver driver,By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		return wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
				);
	}

	public static void accepting_alert(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try {

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
