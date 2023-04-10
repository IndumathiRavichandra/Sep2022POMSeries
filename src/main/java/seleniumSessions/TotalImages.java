package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TotalImages {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println(imagesList.size());

		for(WebElement e : imagesList ) {
			
			String srcValue = e.getAttribute("src");
			String altValue = e.getAttribute("alt");
			String heightValue = e.getAttribute("height");
			
			System.out.println(srcValue + " || " + altValue + " || " + heightValue );
		}
		
		int count =1; 
		for (WebElement we : imagesList) {
			String text1 = we.getAttribute("href");
			
				System.out.println(count + " =  " +   text1);
			
			count++;
			System.out.println("***********************************************************");
			
			
			
		}
	}

}
