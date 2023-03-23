package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrollintoview_eg {
public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[text()='Help Center']")));
	
}
}
