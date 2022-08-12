package com.crm.sdet.Organizations;

import java.awt.Desktop.Action;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;
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
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.Organization;

@Test

public class CreateOrganizationTest extends BaseClass {
@Test(groups="regressionTest")
public void CreateOrganizations() throws Throwable{
	
	System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
	WebDriver_Utility wbUlitity= new WebDriver_Utility();
	Java_Utility Jutility= new Java_Utility();
	File_Utility FUtility= new File_Utility();
	Excel_Utility EUtilites= new Excel_Utility();
	
	String Url = FUtility.getPropertyKeyValue("url");
	String username = FUtility.getPropertyKeyValue("un");
	String password = FUtility.getPropertyKeyValue("pwd");
	
	driver.manage().window().maximize();
	wbUlitity.waitForPageToLoad(driver);
	HomePage homePage = new HomePage(driver);
	homePage.clickOrganizationLink();
	
	Organization organization= new Organization(driver);
	organization.CreateOrganizationPlusSign();
		
		
	int RanNumber =Jutility.getRandomNumber();
	String value = EUtilites.ExcelData("Organization", 0,0)+RanNumber;
	organization.OrganizationName(value);
	organization.SaveButton();
		
		// Verify 
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(value))
				{
			System.out.println("testcase is Pass");
				}else
				{
					System.out.println(" testcase is  fail ");
				}
		
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbUlitity.mouseOverOnElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
			
	}	

}
