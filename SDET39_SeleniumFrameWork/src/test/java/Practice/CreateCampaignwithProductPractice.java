


package Practice;

	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
	public class CreateCampaignwithProductPractice {

		public static void main(String[] args) throws Throwable {
			
			System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
				
			WebDriver_Utility wbUlitity= new WebDriver_Utility();
			Java_Utility Jutility= new Java_Utility();
			File_Utility FUtility= new File_Utility();
			Excel_Utility EUtilites= new Excel_Utility();
			
			String Url = FUtility.getPropertyKeyValue("url");
			String Username= FUtility.getPropertyKeyValue("un");
		    String Password = FUtility.getPropertyKeyValue("pwd");
			
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			wbUlitity.waitForPageToLoad(driver);
			
			
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
				
			// PRODUCT Page
			int Random = Jutility.getRandomNumber();
				
			String Data = EUtilites.ExcelData("Products", 1, 1)+Random;
			System.out.println(Data);
				
				
			driver.findElement(By.name("productname")).sendKeys(Data);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String msg1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if(msg1.contains(Data))
			{
			    System.out.println("Test case is Pass");
				}else
				{
					System.out.println(" test case fail");
				}
		        Thread.sleep(20);
				
				
				driver.findElement(By.xpath("//a[text()='More']")).click();
				driver.findElement(By.name("Campaigns")).click();
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
				
				// SWITCH TO CHILD WINDOW
				
				wbUlitity.switchToWindow(driver, "Campaigns&action");
				
				/*
				 * String parent = driver.getWindowHandle(); 
				 * Set<String> child =driver.getWindowHandles(); 
				 * Iterator<String> it= child.iterator();
				 * while(it.hasNext()) 
				 * 
				 * { 
				 * String child_window=it.next();
				 * driver.switchTo().window(child_window);
				 * 
				 * if(driver.getTitle().contains("Campaigns&action")) 
				 * {
				 *  break; 
				 * 
				 * } 
				 * }
				 */
			
				driver.findElement(By.id("search_txt")).sendKeys(Data);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.id("1")).click();
		   		Thread.sleep(3000);
		   		
		   		// SWITCH BACK TO PARENT WINDOW
		   		

		   		
		   		wbUlitity.switchToBackWindow(driver, "Campaigns&action");
				int Random1 = Jutility.getRandomNumber();

				String Campaign = EUtilites.ExcelData("campaign", 1, 1)+Random1;

				System.out.println(Campaign);
				driver.findElement(By.name("campaignname")).sendKeys(Campaign);
				driver.findElement(By.name("button")).click();
				String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(msg.contains(Campaign))
						{
					System.out.println("Test case is Pass");
						}else
						{
							System.out.println(" test case fail");
						}
				Thread.sleep(20);
				
				//SIGN OUT
		     	WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		     	wbUlitity.mouseHover(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				driver.close();
				
			}
		}


