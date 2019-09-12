package Automation.POC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
      static WebDriver driver;
      
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream Fi = new FileInputStream("/Users/nisum/eclipse-workspace/POC/src/test/java/Automation/POC/config.properties");
		prop.load(Fi);
		
		if (prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("gnkumar25@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("      ");
		if(driver.findElement(By.id("SubmitLogin")).isDisplayed()) {
			driver.findElement(By.id("SubmitLogin")).click();
		}
		
		// Validate the user has been logged in successfully 
		
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("logout"))));
        System.out.println("Successfully Logged in ");
		driver.close();
		
        
	
	
	
	
	
	}

}
