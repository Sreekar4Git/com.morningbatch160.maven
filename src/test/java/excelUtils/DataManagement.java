package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataManagement {
	
	public static void main (String[] args) throws Exception {
		
		File file = new File(System.getProperty("user.dir")+"/datafiles/employee2.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet("Sheet1");
		
		String data = sheet.getRow(0).getCell(0).toString();
		System.out.println(data);
	}

}
