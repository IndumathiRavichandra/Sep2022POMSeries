package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {
	
	@DataProvider
	public Object[][] loginNegativeData() {
		
		return new Object[][] {
			
			{"asd@gmail.com", "sadasf123"},// wrong user name, wrong pswd
			{"indu@gmail.com", "sadasf123"},//correct user name, wrong pswd
			{"indu@gmail.com", " "},//correct user name, blank pswd
			{"induasdad@gmail.com", "Selenium13 "},//wrong user name, correct pswd
			{" ", " "}, //both blank
			
		};
			
		}

	
	
	
	
	@Test(dataProvider = "loginNegativeData" )
	public void loginNegativeTest(String username, String password) {
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("username");
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		
		String errorMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		
		Assert.assertTrue(errorMsg.contains("Warning"));
		
		
		
	}

	

}
