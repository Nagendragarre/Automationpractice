package Automation.POC;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Objectrepo_parser {
	
      static WebDriver driver;
 
      
      
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Objectrepo_parser parser = new Objectrepo_parser();
	     
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
		//WebElement Username =driver.findElement(parser.getbjectLocator("login_btn"));
		//System.out.println(Username.toString());
		driver.findElement(parser.getbjectLocator("login_btn")).click();
		
		//driver.findElement(By.className("login")).click();
		//driver.findElement(By.id("email")).sendKeys(prop.getProperty("registered_uname"));
		//driver.findElement(By.id("passwd")).sendKeys(prop.getProperty("registered_pwd"));
		
		
		
				
		driver.findElement(parser.getbjectLocator("uname")).sendKeys(prop.getProperty("registered_uname"));
		driver.findElement(parser.getbjectLocator("password")).sendKeys(prop.getProperty("registered_pwd"));
		if(driver.findElement(parser.getbjectLocator("submit_btn")).isDisplayed()) {
			driver.findElement(parser.getbjectLocator("submit_btn")).click();
		}
		
		// Validate the user has been logged in successfully 
		
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parser.getbjectLocator("logout"))));
        System.out.println("Successfully Logged in ");
		driver.close();
		
        
	
	
	
	
	
	}

}
