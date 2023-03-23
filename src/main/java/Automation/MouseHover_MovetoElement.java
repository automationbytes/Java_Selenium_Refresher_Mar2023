package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover_MovetoElement {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//span[text()='Home & Kitchen']")));
	act.moveToElement(driver.findElement(By.xpath("//span[text()='Mattresses']")));
	act.click(driver.findElement(By.xpath("//span[text()='Mattresses']")));
	act.build().perform();
	
}
}
