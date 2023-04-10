package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		//driver.get("https://naveenautomationlabs.com/opencart/");

		Assert.assertEquals(driver.getTitle(), "Your Store");
	}

	@Test(priority = 2)
	public void searchTest() {

		Assert.assertEquals(driver.findElement(By.name("search")).isDisplayed(), true);
	}

}
