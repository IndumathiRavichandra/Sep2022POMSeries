package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableCheckBoxConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://selectorshub.com/xpath-practice-page/");
		

		Thread.sleep(4000);
		
		//driver.findElement(By.xpath("//a[text()='John.Smith']/parent::td/preceding-sibling::td/input")).click();
		selectUserCheckbox("John.Smith");
		selectUserCheckbox("Joe.Root");
		selectUserCheckbox("Jordan.Mathews");
}
	
	public static void selectUserCheckbox(String userName) {
		
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input")).click();
	}

}
