package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook ExcelWBook;	
	private static XSSFSheet ExcelWSheet;
	private static XSSFRow Row;
	private static XSSFCell Cell;

	public static void setExcelFile(String path,String sheet) throws Exception
	{
		try 
		{
				FileInputStream ExcelFile = new FileInputStream(path);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(sheet);
		}
		
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	public static String getCellValue(int row, int col) 
	{
		try 
		{
			Cell = ExcelWSheet.getRow(row).getCell(col);
			String cellData = Cell.getStringCellValue();
		
			return cellData;
		}
		
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	
}
