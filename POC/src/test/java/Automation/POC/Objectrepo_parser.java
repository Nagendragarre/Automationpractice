package Automation.POC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Objectrepo_parser {

	public By getbjectLocator(String locatorName) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream Fi = new FileInputStream("/Users/nisum/git/Automationpractice/POC/src/test/java/Automation/POC/config.properties");
		prop.load(Fi);
		
		String locatorProperty = prop.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];
		By locator = null;
		
		switch(locatorType)
		{
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
		    locator = By.className(locatorValue);
		break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
}
