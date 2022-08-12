package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteintoExcel {
	public static void main(String[] args) throws Throwable {
		 	
		FileInputStream fis = new FileInputStream("./Book3.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet("Sheet1");
		Row r= sh.createRow(1);
		Cell cell= r.createCell(5);
		cell.setCellValue("Shilpa");
		
		FileOutputStream fos= new FileOutputStream("./Book3.xlsx");
		wb.write(fos);
		wb.close();
	}

}
