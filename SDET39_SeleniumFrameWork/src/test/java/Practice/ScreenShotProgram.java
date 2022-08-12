package Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotProgram {
	
public static void main(String[] args) throws Throwable {
	
	System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
	TakesScreenshot ts= (TakesScreenshot)driver;
	
	File ram = ts.getScreenshotAs(OutputType.FILE);
	
	File desktop= new File("./Photo");
	FileUtils.copyFile(ram, desktop);
	driver.close();
	
}

}
