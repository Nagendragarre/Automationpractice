package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utils {
	
	public static Workbook wb;
	public static Sheet sh; 
	public static Row row;
	public static Cell cell;
	
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			
			String fileType = Path.substring(Path.indexOf(".")); 
			File f = new File(Path);
			FileInputStream is = new FileInputStream(f);
			if(fileType.equals(".xls"))
				wb = new HSSFWorkbook(is);
			else if(fileType.equals(".xlsx"))
				wb = new XSSFWorkbook(is);
			
			sh=wb.getSheet(SheetName);
		} catch (Exception e){
				throw (e);
		}
	}
	
	public static void config_excel (String Path) {
		
		try {
			String fileType = Path.substring(Path.indexOf(".")); 
			File f = new File(Path);
			FileInputStream is = new FileInputStream(f);
			if(fileType.equals(".xls"))
				wb = new HSSFWorkbook(is);
			else if(fileType.equals(".xlsx"))
				wb = new XSSFWorkbook(is);
			
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public static String getCellData(int sheetnumber, int RowNum, int ColNum) throws Exception{

		try{
			sh=wb.getSheetAt(sheetnumber);
				cell = sh.getRow(RowNum).getCell(ColNum);
				String CellData = cell.getStringCellValue();
				return CellData;

			}catch (Exception e){
					return"";
			}}
	
	public static String getCellData(String Sheetname, int RowNum, int ColNum) throws Exception{

		try{
			sh=wb.getSheet(Sheetname);
				cell = sh.getRow(RowNum).getCell(ColNum);
				String CellData = cell.getStringCellValue();
				return CellData;

			}catch (Exception e){
					return"";
			}}

}
