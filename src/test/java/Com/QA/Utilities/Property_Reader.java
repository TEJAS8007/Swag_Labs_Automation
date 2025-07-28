package Com.QA.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Property_Reader {

	static Properties pro;
	static WebDriver driver;

	public static Properties init_prop() {

		try {
			FileInputStream file = new FileInputStream("src/test/resources/Data/Config.properties");

			pro=new Properties();
			pro.load(file);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pro;
	}

	public static Properties login_prop() {

		try {
			FileInputStream file = new FileInputStream("src/test/resources/Data/Login.properties");

			pro=new Properties();
			pro.load(file);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pro;
	}


}
