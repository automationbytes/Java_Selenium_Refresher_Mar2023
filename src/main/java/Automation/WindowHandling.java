package Automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {

		/*
		 * getWindowhandle - it will get information of current open window
		 * getWindowhandles - it will get the information all open windows
		 * 
		 * 
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.openmultipleurl.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("list_urls")).sendKeys("https://www.google.com/");
		driver.findElement(By.id("list_urls")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("list_urls")).sendKeys("https://www.facebook.com/");
		driver.findElement(By.id("list_urls")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("list_urls")).sendKeys("https://www.bing.com/");
		driver.findElement(By.id("list_urls")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("list_urls")).sendKeys("https://www.amazon.com/");
		driver.findElement(By.id("list_urls")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@value=\"Go Now\"]")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> allOpenWindow = driver.getWindowHandles();
		Thread.sleep(2000);
		System.out.println(allOpenWindow);
		for(String a : allOpenWindow) {
			if(!a.equals(parentWindow)) {
				Thread.sleep(5000);
				driver.switchTo().window(a);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());		}
				
			if(driver.getTitle().contains("Bing")) {
				driver.findElement(By.name("q")).sendKeys("Hello");
			}else {
				driver.close();
			}
			
		}
		
		
		
	}
}
