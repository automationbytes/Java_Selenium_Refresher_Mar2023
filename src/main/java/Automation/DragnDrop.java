package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDrop {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
	Actions act = new Actions(driver);
//	act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")));
//	act.build().perform();

	act.clickAndHold(driver.findElement(By.id("draggable")));
	act.release(driver.findElement(By.id("droppable")));
	act.build().perform();

}
}
