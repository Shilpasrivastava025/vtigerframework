package com.crm.sdet.Products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductValidation;
import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.CreateProductAndDelete;

public class CreateProductsTest extends BaseClass{
@Test(groups={"smoketest", "regressionTest"})

public void CreateProduct() throws Throwable
{
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
	homePage.clickProductsLink();
	
	CreateProductAndDelete productPage = new CreateProductAndDelete(driver);
	productPage.PlusProduct();
	int ranNum=Jutility.getRandomNumber();
	String ProductName= EUtilites.ExcelData("Products", 2, 0)+ranNum;

	productPage.ProductnameField(ProductName);
	productPage.SaveProduct();

	
	ProductValidation actualProductName = new ProductValidation(driver);
	String actualProductData = actualProductName.actualProductName();
	Assert.assertEquals(actualProductData.contains(ProductName), true);
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wbUlitity.mouseHover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
}
}
