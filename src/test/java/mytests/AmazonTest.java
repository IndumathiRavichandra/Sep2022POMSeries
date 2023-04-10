package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	

	@Test(priority = 1)
	public void titleTest() {
		//driver.get("https://www.amazon.com/");
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
	}

	@Test(priority = 2)
	public void searchTest() {

		Assert.assertEquals(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(), true);
	}

	
}
