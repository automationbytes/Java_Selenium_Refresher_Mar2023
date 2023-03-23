package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathh_Eg {
	/*
	 *  Xpath - XML Path
	 *  2 types
	 *  
	 *  1) absolute xpath - start from root node level
	 *  	/
	 *  2) relative xpath - start from relative node level
	 *   // (recommended)
	 * 
	 *  //tagname[@attribute = 'value']
	 *  tagname - starting of the node
	 *  
	 *  //a[@data-testid="open-registration-form-button"]
	 *  
	 *  //a[contains(@data-testid,"open-registration-form")]
	 *  
	 *  CSS - Case cading style sheet
	 *  
	 *  a[data-testid=open-registration-form-button]
	 *  
	 */

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://www.facebook.com/");
		
	//	driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		driver.findElement(By.xpath("//a[contains(@data-testid,\"open-registration-form\")]")).click();
	//	driver.findElement(By.xpath("//a[@role=\"button\"]")).click();
		
		//Thread.sleep(30000); not recommended
		
		//explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		//fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name=\"firstname\"]"))));
		
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Tom");
	}
	
}
