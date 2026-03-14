package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public XSSFSheet loadXlxsFile(String path, String sht) throws Exception  {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sht);
		return sheet;
	}
	
	public String[][] retrieveXLXSData(String path, String sheet) throws Exception{
		XSSFSheet sht = loadXlxsFile(path, sheet);
		int lastrow= sht.getLastRowNum();
		int lastcolumn= sht.getRow(0).getLastCellNum();
		String data[][]= new String[lastrow+1][lastcolumn];
		
		for(int i=0;i<lastrow;i++) 
		{
			
			for(int j=0;j<lastcolumn;j++) 
			{
				DataFormatter dataformatter= new DataFormatter();
				String formattedcellStr =dataformatter.formatCellValue(sht.getRow(i).getCell(j));
				//System.out.print(formattedCellStr + "\t\t\t");
				data[i][j]= formattedcellStr;
			}
			
		}
		return data;
	}
		
		public String readPropFile(String  path, String proper) throws Exception {
			File file= new File(path);
			FileInputStream fis= new FileInputStream(file);
			Properties config = new Properties();
			config.load(fis);
			String str = config.getProperty(proper);
			return str;
			
		}
		
	

}
