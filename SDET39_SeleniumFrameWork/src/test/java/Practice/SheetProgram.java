package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SheetProgram {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
	
	FileInputStream fis = new FileInputStream("./Book1.xlsx");

	Workbook wb = WorkbookFactory.create(fis);
    Sheet sheet= wb.getSheet("Sheet1");//Read data from Excel
	Row row= sheet.getRow(1);// Get The control Of Row
	Cell cell= row.getCell(0); 	//Get the control of Cell
    String value = cell.getStringCellValue();//Get the value of Cell
    System.out.println(value);
	 	
}
}
