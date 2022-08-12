package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiger {
public static void main(String[] args) throws IOException {
	
	System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
	FileInputStream fis = new FileInputStream("./CommonsProperty.properties");
    Properties p = new Properties();
    p.load(fis);
    
    
    String URL= p.getProperty("url");
    String UN= p.getProperty("un");
    String PWD= p.getProperty("pwd");
    
    WebDriver driver = new ChromeDriver();
    driver.get(URL);    
    driver.findElement(By.name("user_name")).sendKeys(UN);
    driver.findElement(By.name("user_password")).sendKeys(PWD);
    driver.findElement(By.id("submitButton")).click();
    
}
}
