package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
public static void main(String[] args) {
	
//	WebDriverManager.chromedriver().setup();
//	//shortcut to import everything - ctrl+shift+o
//	WebDriver driver = new ChromeDriver();
	
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://www.google.com/");
}
}
