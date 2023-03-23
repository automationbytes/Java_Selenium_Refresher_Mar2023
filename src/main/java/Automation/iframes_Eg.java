package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframes_Eg {
	public static void main(String[] args) {
/*
 *  iframes - html inside a html
 *  3 ways
 *  
 *  1) id/name
 *  2) any of the locators strategy
 *  3) index
 *  
 *  //alerts - popup
 *  
 *  4 actions with alerts
 *  
 *  accept- positve things (okay, yes, allow)
 *  dismiss - negative things (cancel, no, disallow)
 *  sendkeys - enter the value
 *  getText - 
 * 
 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.xpath("//a[@onclick=\"retheme()\"]")).click();
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		driver.switchTo().alert().sendKeys("Spiderman");
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		

		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[@onclick=\"retheme()\"]")).click();
	}
}
