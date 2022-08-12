package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteProduct {
public static void main(String[] args) throws Throwable {
	
	System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
	
	FileInputStream fis= new FileInputStream("CommonsProperty.properties");
	Properties p= new Properties();
	p.load(fis);
	
	String Url = p.getProperty("url");
	String UN = p.getProperty("un");
	String PWD = p.getProperty("pwd");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).click();
	
	Thread.sleep(10);
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.id("10")).click();

	driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();	
}
}
