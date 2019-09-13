package Automation.POC;

import org.openqa.selenium.WebDriver;

public class Navigate {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	public void forward (WebDriver driver) {
		driver.navigate().forward();
		
	}
    public void backward (WebDriver driver) {
    	driver.navigate().back();
    	
    }
}
