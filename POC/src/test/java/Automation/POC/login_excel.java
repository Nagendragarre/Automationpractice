package Automation.POC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.Healper;
import utils.excel_utils;

public class login_excel extends Healper {
	//public static 

	public static void main(String[] args) throws Exception {
		//// TODO Auto-generated method stub
		
		config_excel("/Users/nisum/git/Automationpractice/POC/TD.xlsx");
		
		
		System.out.println("Successfully loaded the Excel Data ");
		
		//String URL = getCellData(1,1);
		//String Browser = getCellData(2, 1);
		String URL = getCellData(0, 1, 1);
		String Browswer = getCellData(0, 2, 1);
		String login_btn = getCellData(1,1, 1);
		
		
		System.out.println(URL);
		System.out.println(Browswer);
		if (Browswer.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(URL);
			}
		//setExcelFile("/Users/nisum/git/Automationpractice/POC/TD.xlsx", "Test");
		//String login_btn = getCellData(0,1, 3);
		System.out.println("login button" +login_btn);
		
		driver.findElement(getbjectLocator(getCellData(1,1, 1))).click();
		driver.findElement(getbjectLocator(getCellData(1, 2, 1))).sendKeys(getCellData(0, 3, 1));
		driver.findElement(getbjectLocator(getCellData(1, 3, 1))).sendKeys(getCellData(0, 4, 1));
		Actions act = new Actions(driver);
		if(driver.findElement(getbjectLocator(getCellData(1, 4, 1))).isDisplayed()) {
			//driver.findElement(getbjectLocator("submit_btn")).click();
			act.sendKeys(Keys.RETURN).perform();
			
		}
	    Thread.sleep(6000);
		driver.close();
		
		
		
		
		
		
		
		
		
		}
		

	}


