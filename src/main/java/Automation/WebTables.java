package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Select pageSize = new Select(driver.findElement(By.name("products-grid_length")));
		pageSize.selectByVisibleText("100");
		
		Thread.sleep(5000);
		
		int rowSize = driver.findElements(By.xpath("//table[@id=\"products-grid\"]//tr")).size();
		System.out.println(rowSize);
		
		for(int i = 1; i<rowSize; i++) {
			String productName = driver.findElement(By.xpath("//table[@id=\"products-grid\"]//tr["+i+"]/td[3]")).getText();
			System.out.println(productName);
			if(productName.equals("Windows 8 Pro")) {
				driver.findElement(By.xpath("//table[@id=\"products-grid\"]//tr["+i+"]/td[8]/a")).click();
				break;
			}
		}
		
	}
}
