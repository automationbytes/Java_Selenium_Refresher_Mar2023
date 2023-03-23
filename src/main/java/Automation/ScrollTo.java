package Automation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollTo {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	Thread.sleep(10000);
	
	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	
}
}
