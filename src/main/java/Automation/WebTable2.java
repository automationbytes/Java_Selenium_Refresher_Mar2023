package Automation;

import java.time.Duration;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable2 {
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
		
		int colSize = driver.findElements(By.xpath("//table[@id=\"products-grid\"]//th")).size();
		System.out.println(colSize);
		LinkedHashMap al = new LinkedHashMap();
		for(int j = 1; j<=colSize; j++) {
			String Header = driver.findElement(By.xpath("//table[@id=\"products-grid\"]//th["+j+"]/div")).getAttribute("textContent");
			System.out.println(Header);
			al.put(Header,j);
		}
		
		System.out.println(al);
		
		System.out.println(al.get("Edit"));
		
		for(int i = 1; i<rowSize; i++) {
			String productName = driver.findElement(By.xpath("//table[@id=\"products-grid\"]//tr["+i+"]/td[3]")).getText();
			System.out.println(productName);
			
			
			if(productName.equals("Windows 8 Pro")) {
				driver.findElement(By.xpath("//table[@id=\"products-grid\"]//tr["+i+"]/td["+al.get("Edit")+"]/a")).click();
				break;
			}
		}
		
	}
}
