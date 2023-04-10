package testngSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationTest {
	
	//global pre condition -- appl running
	//pre condition
	//test steps
	//validations: act vs exp result ------------Assertions
	//post step
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("@BeforeSuite---connectWithDB");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("@BeforeTest---createUser");
	}
	
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("@BeforeClass---launchBrowser");
	}
	
	 
	@BeforeMethod
	public void login() {
		System.out.println("@BeforeMethod---login to app");
	}
	
	
	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
		
	}
	@Test
	public void searchTest() {
		System.out.println("searchTest");
		
	}
	@Test
	public void cartTest() {
		System.out.println("cartTest");
		
	}
	
	@AfterMethod
	public void Logout() {
		System.out.println("After method logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("After class closeBrowser");
	}
	@AfterTest
	public void deleteUser() {
		System.out.println("AfterTest deleteUser");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("@AfterSuite disconnectWithDB");
	}
}
