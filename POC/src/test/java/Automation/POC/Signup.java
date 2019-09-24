package Automation.POC;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Objectrepo_parser;

public class Signup extends Objectrepo_parser {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Objectrepo_parser parser = new Objectrepo_parser();
		Properties prop = new Properties();
		FileInputStream Fi = new FileInputStream("/Users/nisum/git/Automationpractice/POC/src/test/java/Automation/POC/config.properties");
		prop.load(Fi);
		
		
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        // Chrome Initialization 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Navigating to the URL
		driver.get(prop.getProperty("url"));
		driver.findElement(parser.getbjectLocator("login_btn")).click();
		// Creating a new user account
		driver.findElement(parser.getbjectLocator("createemail")).sendKeys(prop.getProperty("new_username"));
		driver.findElement(parser.getbjectLocator("SubmitCreate")).click();
		// Filling the form for the new user creation
		driver.findElement(parser.getbjectLocator("id_gender1")).click();
		driver.findElement(parser.getbjectLocator("customer_firstname")).sendKeys(prop.getProperty("new_firstname"));
		driver.findElement(parser.getbjectLocator("customer_lastname")).sendKeys(prop.getProperty("new_lastname"));
		driver.findElement(parser.getbjectLocator("passwd")).sendKeys(prop.getProperty("new_password"));
	    Select days = new Select (driver.findElement(parser.getbjectLocator("days")));
		Select months = new Select (driver.findElement(parser.getbjectLocator("months")));
		Select Years = new Select (driver.findElement(parser.getbjectLocator("years")));
		days.selectByIndex(8);
		months.selectByValue("7");
		Years.selectByValue("1990");
	    driver.findElement(parser.getbjectLocator("firstname")).sendKeys(prop.getProperty("new_firstname"));
	    driver.findElement(parser.getbjectLocator("lastname")).sendKeys(prop.getProperty("new_lastname"));
	    driver.findElement(parser.getbjectLocator("address1")).sendKeys(prop.getProperty("new_address1"));
	    driver.findElement(parser.getbjectLocator("address2")).sendKeys(prop.getProperty("new_address2"));
	    driver.findElement(parser.getbjectLocator("city")).sendKeys(prop.getProperty("new_city"));
	    Select States = new Select ( driver.findElement(parser.getbjectLocator("id_state")));
	    Select Country = new Select (driver.findElement(parser.getbjectLocator("id_country")));
	    States.selectByValue("1");
	    driver.findElement(parser.getbjectLocator("postcode")).sendKeys(prop.getProperty("new_postcode"));
	    Country.selectByValue("21");
	    driver.findElement(parser.getbjectLocator("phone_mobile")).sendKeys(prop.getProperty("new_phone_mobile"));
	    driver.findElement(parser.getbjectLocator("alias")).sendKeys(prop.getProperty("new_alias"));
	    driver.findElement(parser.getbjectLocator("submitAccount")).click();
	    // Verifying and validating the new user creation.
	    driver.findElement(By.xpath("//a[@href='http://automationpractice.com/']")).click();
	    WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("logout"))));
        System.out.println("Successfully Registered");
	   	driver.close();

	}

}
