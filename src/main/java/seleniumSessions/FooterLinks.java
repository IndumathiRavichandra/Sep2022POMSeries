package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FooterLinks {

	static WebDriver driver;

	public static void doClickOnElement(By locator, String linkText) {

		List<WebElement> footerLinklist = driver.findElements(locator);

		System.out.println(footerLinklist.size());

		for (WebElement e : footerLinklist) {

			String text = e.getText();
			System.out.println(text);

			if (text.contains("linkText")) {

				e.click();
				
			}
			
			}
		}
	

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in/");

//		List<WebElement> footerLinks  = driver.findElements(By.xpath("//div[@class='KxwPGc AghGtd']/a"));
//		
//		System.out.println(footerLinks.size());
//		
//		for (WebElement e : footerLinks) {
//			
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.contains("Advertising")) {
//				
//				e.click();
//				break;
//			}

		By footerlocator = By.xpath("//div[@class='KxwPGc AghGtd']/a");
		doClickOnElement(footerlocator, "Advertising");
		}

}
