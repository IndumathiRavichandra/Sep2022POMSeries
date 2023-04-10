package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IFrameHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//img[@title= 'vehicle-registration-forms-and-templates']")).click();

		Thread.sleep(3000);

		List <WebElement> frameList =driver.findElements(By.tagName("frame"));
		System.out.println(frameList.size());
		
		
		
		driver.switchTo().frame("frame-one748593425");

		driver.switchTo().defaultContent();
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("test-12345");

	}

}
