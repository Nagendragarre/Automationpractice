import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Healper;

public class Steps extends Healper {

	@BeforeTest
	public void intiate_browser() {
		System.out.println("-----------------------");
		System.out.println("|   Before Test       | ");
		System.out.println("|   initiating Browser| ");
		System.out.println("-----------------------");
		browser_init("chrome");
	}

	@AfterTest
	public void close_browser() {
		System.out.println("--------------------");
		System.out.println("|   After Test     | ");
		System.out.println("|   Closing Browser| ");
		System.out.println("--------------------");
		exit_browser();
	}

	@BeforeClass
	public void set_excel() {
		System.out.println("--------------------");
		System.out.println("|   Before Class   | ");
		System.out.println("--------------------");
		config_excel("/Users/nisum/git/Automationpractice/POC/TD.xlsx");
	}

	@Test(priority = 1)
	public void open_site() {
		open_site("http://automationpractice.com/index.php");
	}

	@Test(priority = 2)
	public void login_user() throws Exception {
		registerd_user_login();
	}

}
