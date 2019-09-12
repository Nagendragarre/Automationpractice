package Automation.POC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sections_stats {

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
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("registered_uname"));
		driver.findElement(By.id("passwd")).sendKeys(prop.getProperty("registered_pwd"));
		driver.findElement(By.id("SubmitLogin")).click();
		
		// Verify the different Section and print on the console
		
		//List<WebElement> menu_list = driver.findElements(By.className("sf-with-ul"));
		List<WebElement> menu_list = driver.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));
		
		int Size_of_list = menu_list.size();
		System.out.println("Size of the list is "+Size_of_list);
		System.out.println("-------------------------------------");
		//printing the Menu on the Console
		for(int i=0;i<menu_list.size();i++) {
			System.out.println(menu_list.get(i).getText());
		}
		// Verifying weather the Menu links are clickable/active
		
		for(int i=0;i<Size_of_list;i++) {
			if(menu_list.get(i).isEnabled()) {
				System.out.println(menu_list.get(i).getText()+ " is enabled");
			}
			else
				System.out.println(menu_list.get(i).getText()+ " is disabled");
		}
		System.out.println("*****************************************");
		System.out.println("*                                       *");
		System.out.println("*****************************************");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category'][@class='sf-with-ul']"))).build().perform();
		
		List<WebElement> Women_submenu = driver.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]"));		
		for(int i=0;i<Women_submenu.size();i++)
		{
			System.out.println(Women_submenu.get(i).getText());
		}
		System.out.println("*****************************************");
		for(int j=0;j<Women_submenu.size();j++) {
			
			if(menu_list.get(j).isEnabled()) {
				
				System.out.println(Women_submenu.get(j).getText()+ " is enabled");
			}
			else
				System.out.println(Women_submenu.get(j).getText()+ " is disabled");
		}
		
		act.moveToElement(driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]"))).build().perform();
		List<WebElement> Dresses_submenu = driver.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]"));		
		System.out.println("*****************************************");
		System.out.println("*                                       *");
		System.out.println("*****************************************");
		
		for(int i=0;i<Dresses_submenu.size();i++)
		{
			System.out.println(Dresses_submenu.get(i).getText());
		}
		System.out.println("*****************************************");
		for(int j=0;j<Dresses_submenu.size();j++) {
			
			if(Dresses_submenu.get(j).isEnabled()) {
				
				System.out.println(Dresses_submenu.get(j).getText()+ " is enabled");
			}
			else
				System.out.println(Dresses_submenu.get(j).getText()+ " is disabled");
		}
		
		driver.quit();
		
		
	}

}
