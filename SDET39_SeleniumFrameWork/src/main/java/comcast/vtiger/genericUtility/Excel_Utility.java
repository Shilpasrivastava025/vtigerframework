package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String ExcelData(String SheetName, int RowNum, int CellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		  Sheet sheet=book.getSheet(SheetName); 
		  Row row=sheet.getRow(RowNum); 
		  Cell cell=row.getCell(CellNum);
		  String data = cell.getStringCellValue(); 
		  return data;
		
		
		// Data formatter is a class which is coming from pache.poi.ss. whatever data is there it will fetch it from sheet

		/* DataFormatter format= new DataFormatter();
		return format.formatCellValue(book.getSheet(SheetName).getRow(RowNum).getCell(CellNum));
		*/

	
	}	
}