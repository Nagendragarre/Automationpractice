package Automation.POC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Order_placement {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
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
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("registered_uname"));
		driver.findElement(By.id("passwd")).sendKeys(prop.getProperty("registered_pwd"));
		driver.findElement(By.id("SubmitLogin")).click();
		
		// clicking on the Women Section
		
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]")).click();
		Actions act = new Actions(driver);
		WebElement product_info = driver.findElement(By.xpath(" //*[@id=\"center_column\"]/ul/li[1]/div/div[2]/span"));
		act.moveToElement(product_info).build().perform();
		Thread.sleep(3000);
		System.out.println(product_info.getText());
		if(product_info.getText().equals("In stock")) {
			System.out.println("Product available");
			driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div/div/a[2]/span")).click();
		}
		Thread.sleep(3000);
		
		// Adding to the cart
		
		driver.switchTo().frame(0);
		Thread.sleep(4000);
		// Getting Title
		String dress_Name = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Selected Name of Dress is" + dress_Name);
		// getting price
		String dress_Cost = driver.findElement(By.id("our_price_display")).getText();
		System.out.println("Selected Cost of Dress is " + dress_Cost);
		driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		
		//Placing the Order
		
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='form']/p/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();
		
		// Exiting from the browser
		
		driver.close();

		

	}

}
