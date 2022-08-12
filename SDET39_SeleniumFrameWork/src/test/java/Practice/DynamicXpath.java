package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicXpath {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("fromCity"));
		WebElement destination = driver.findElement(By.id("toCity"));
		
		source.sendKeys("New Delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5'][2]"));
		
		
	}
}


