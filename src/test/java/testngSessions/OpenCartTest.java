package testngSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenCartTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	
	//*****************Not a good way of writing all Asserts in one single TEst Cases. Create n number of test cases.
	@Test(enabled = false)//*******************enabled = false or use invocationCount= 0 then it will not participate in the run
	public void loginPageTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login", "..............opencart loginpage title is incorrect");
		
		boolean flag = driver.findElement(By.xpath("//div[@id='logo']//img")).isDisplayed();
		Assert.assertEquals(flag, true);
		
		flag = driver.findElement(By.linkText("Forgotten Pass word")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	

	@Test(description = "open cart title test", priority = 1) // description describes the test in detail, // incase the
																// test fails the last params prints
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login", "..............opencart loginpage title is incorrect");
		System.out.println("...............Ending test");

	}

	@Test(description = "open cart logo test", priority = 2)
	public void logoTest() {
		boolean flag = driver.findElement(By.xpath("//div[@id='logo']//img")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(description = "forgot Pwd Link Exist Test", priority = 3)
	public void forgotPwdLinkExistTest() {
		boolean flag = driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
