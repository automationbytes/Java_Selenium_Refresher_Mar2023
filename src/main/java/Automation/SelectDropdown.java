package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://admin-demo.nopcommerce.com/Admin/Order/ShipmentList");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Select countrylist = new Select(driver.findElement(By.id("CountryId")));
		//dropdown selection can be happen in 3 ways
		/*
		 * selectbyvalue - you need provide value from dom
		 * selectbyvisibletext - based on UI text
		 * selectbyindex - based on occurance
		 */
		
	//	countrylist.selectByValue("42");
		//countrylist.selectByVisibleText("Mexico");
		countrylist.selectByIndex(9);
		
		for(WebElement c : countrylist.getOptions()) {
			System.out.println(c.getText());
			if(c.getText().contains("United Kingdom")) {
				System.out.println("value found");
				break;
			}
		//	System.out.println(c.getAttribute("value"));
		}
		//System.out.println(countrylist.getOptions().size());
	}
}
