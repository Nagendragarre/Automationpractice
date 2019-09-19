package Automation.POC;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Healper {
	public static Workbook wb;
	public static Sheet sh; 
	public static Row row;
	public static Cell cell;
	public static WebDriver driver;
	
	
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
	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{
				cell = sh.getRow(RowNum).getCell(ColNum);
				String CellData = cell.getStringCellValue();
				return CellData;

			}catch (Exception e){
					return"";
			}}
	
	public static void click(WebElement element) {
		element.click();
	}

	public void forward (WebDriver driver) {
		driver.navigate().forward();
		
	}
    public void backward (WebDriver driver) {
    	driver.navigate().back();
    	
    }
    public void dropdown_select_index (Select element, int i) {
    	element.selectByIndex(i);
    	
    	
    }
    public void dropdown_select_string (Select element, String str) {
    	element.selectByValue(str); 	
    }
    public void open_site(String URL) {
    	driver.get(URL);
    }
    public void dropdown_deselectall (Select element) {
    	element.deselectAll();
    }
    




}
