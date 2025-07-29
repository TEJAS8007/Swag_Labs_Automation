package Com.QA.Utilities;

import java.util.*;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_factory {

	static  WebDriver driver;
	static Properties prop;

	public static WebDriver init_Driver() {

		String browserNAme = Property_Reader.init_prop().getProperty("browser").trim();
		String url = Property_Reader.init_prop().getProperty("url").trim();

		if(browserNAme.equals("chrome")) {
			
			ChromeOptions chrome = new ChromeOptions();
			chrome.addArguments("--remote-allow-origins=*");  
			chrome.addArguments("--disable-notifications");
			chrome.addArguments("--disable-extensions");
			chrome.addArguments("--disable-popup-blocking");
			chrome.addArguments("--start-maximized");
			chrome.addArguments("--incognito");  

			driver = new ChromeDriver(chrome);
		}
		else if(browserNAme.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please Enter Browser Correctly...");
		}
		driver.get(url);
		return driver;
	}
}
