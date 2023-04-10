package testngSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver;

	@BeforeTest
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

	@Test(description = "open cart title test") // description describes the test inj detail
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login", "..............opencart loginpage title is incorrect");// incase the
																											// test
																											// fails the
																											// last
																											// param
																											// prints
	}

	@Test(description = "open cart logo test")
	public void logoTest() {
		boolean flag = driver.findElement(By.xpath("//div[@id='logo']//img")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(description = "forgot Pwd Link Exist Test")
	public void forgotPwdLinkExistTest() {
		boolean flag = driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
