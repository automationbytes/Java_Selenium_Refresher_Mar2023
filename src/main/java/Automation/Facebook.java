package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		/* 8  locators
		 * 
		 *  id
		 *  name
		 *  classname
		 *  tagname
		 *  link text
		 *  partial link text
		 *  xpath
		 *  css
		 */
		
		driver.findElement(By.id("email")).sendKeys("test@facebook.com");
		
		driver.findElement(By.name("pass")).sendKeys("facepass");
		
	//	driver.findElement(By.name("login")).click();
		
	//driver.findElement(By.linkText("Forgotten password?")).click();
		
		driver.findElement(By.partialLinkText("Forgotten pass")).click();
	}
}
