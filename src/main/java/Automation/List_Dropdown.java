package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List_Dropdown {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.id("src")).sendKeys("Del");
		
		List<WebElement> sourcelist = driver.findElements(By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"));
		for(WebElement s : sourcelist) {
			System.out.println(s.getText());
			if(s.getText().contains("Morigate")) {
				s.click();
				break;
			}
		}
		
	
		driver.findElement(By.id("dest")).sendKeys("Kol");
		List<WebElement> destlist = driver.findElements(By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"));
		
		for(WebElement d : destlist) {
			System.out.println(d.getText());
			if(d.getText().equals("Airport, Kolkata")) {
				d.click();
				break;
			}
		}
		
		driver.findElement(By.id("onward_cal")).click();
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]//td"));
		
		for(WebElement D : dates) {
			System.out.println(D.getText());
			
			if(D.getText().equals("27")) {
				D.click();
				break;	
			}
		}
		
	}
	
}
