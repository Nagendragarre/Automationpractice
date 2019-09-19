package Automation.POC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_validation extends Navigate {
     static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Navigation_validation nv = new Navigation_validation();

		Properties prop = new Properties();
		FileInputStream Fi = new FileInputStream("/Users/nisum/git/Automationpractice/POC/src/test/java/Automation/POC/config.properties");
		prop.load(Fi);
		
		if (prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		
		driver.get(prop.getProperty("url"));
		
		nv.backward(driver);
		nv.forward(driver);
		driver.close();
	}

}
