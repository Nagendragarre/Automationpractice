package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Healper extends excel_utils {
	
	
	public static WebDriver driver;
	
	public static void browser_init(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			}
	}
	 public void open_site(String URL) {
	    	driver.get(URL);
	    }
	 public void exit_browser() {
		 driver.close();
	 }
	
	
	
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
   
    public void dropdown_deselectall (Select element) {
    	element.deselectAll();
    }
public static By getbjectLocator(String locatorName) throws Exception {
		
		
	    System.out.println(locatorName.toString());
		String locatorType = locatorName.split(":")[0];
		String locatorValue = locatorName.split(":")[1];
		By locator = null;
		
		switch(locatorType)
		{
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
		    locator = By.className(locatorValue);
		break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}

public static void registerd_user_login() throws Exception {
	driver.findElement(getbjectLocator(getCellData(1,1, 1))).click();
	driver.findElement(getbjectLocator(getCellData(1, 2, 1))).sendKeys(getCellData(0, 3, 1));
	driver.findElement(getbjectLocator(getCellData(1, 3, 1))).sendKeys(getCellData(0, 4, 1));
	Actions act = new Actions(driver);
	if(driver.findElement(getbjectLocator(getCellData(1, 4, 1))).isDisplayed()) {
		//driver.findElement(getbjectLocator("submit_btn")).click();
		act.sendKeys(Keys.RETURN).perform();
		
	}
    Thread.sleep(6000);
}



}
