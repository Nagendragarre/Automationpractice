package Automation.POC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_excel extends Healper {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		setExcelFile("/Users/nisum/git/Automationpractice/POC/TD.xlsx", "TestData");
		
		
		System.out.println("Successfully loaded the Excel Data ");
		
		String URL = getCellData(1,1);
		String Browser = getCellData(2, 0);
		
		System.out.println(URL);
		System.out.println(Browser);
		if (Browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(URL);
			
		}
		
		
		
		
		
		
		
		
		
		}
		

	}


