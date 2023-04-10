package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PseudoElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		String mandatory_text = js.executeScript(
				" return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')")
				.toString();
		System.out.println(mandatory_text);
		
		if(mandatory_text.contains("*")) {
			
			System.out.println("this is mandatory field");
		}

	}

}
 