package Automation.POC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        // Chrome Initialization 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Navigating to the URL
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		// Creating a new user account
		driver.findElement(By.id("email_create")).sendKeys("ttt.gaptech@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		// Filling the form for the new user creation
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Test");
		driver.findElement(By.id("customer_lastname")).sendKeys("Test");
		driver.findElement(By.name("passwd")).sendKeys("tester");
	    Select days = new Select (driver.findElement(By.id("days")));
		Select months = new Select (driver.findElement(By.id("months")));
		Select Years = new Select (driver.findElement(By.id("years")));
		days.selectByIndex(8);
		months.selectByValue("7");
		Years.selectByValue("1990");
	    driver.findElement(By.id("firstname")).sendKeys("Test");
	    driver.findElement(By.id("lastname")).sendKeys("Test");
	    driver.findElement(By.id("address1")).sendKeys("559 S Court St");
	    driver.findElement(By.id("address2")).sendKeys("Grove Court Apartments");
	    driver.findElement(By.id("city")).sendKeys("Montgomery");
	    Select States = new Select ( driver.findElement(By.name("id_state")));
	    Select Country = new Select (driver.findElement(By.name("id_country")));
	    States.selectByValue("1");
	    driver.findElement(By.id("postcode")).sendKeys("36104");
	    Country.selectByValue("21");
	    driver.findElement(By.id("phone_mobile")).sendKeys("334-296-3024");
	    driver.findElement(By.id("alias")).sendKeys("Home");
	    driver.findElement(By.id("submitAccount")).click();
	    // Verifying and validating the new user creation.
	    driver.findElement(By.xpath("//a[@href='http://automationpractice.com/']")).click();
	    WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("logout"))));
        System.out.println("Successfully Registered");
	   	driver.close();

	}

}
