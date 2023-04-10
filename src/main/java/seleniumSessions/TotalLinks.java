package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TotalLinks {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		
		List<WebElement> linksList =  driver.findElements(By.tagName("a"));
		System.out.println("Total links : " + linksList.size() );
		
		/*
		for (int i =0; i<=linksList.size(); i++) {
			String text = linksList.get(i).getText();
			if(!(text.length()==0)) {
					
			System.out.println(i + "=" + text);
			
			
		}
		*/
			
			System.out.println("************************repeat***********************************");
			
			int count =1;
			for (WebElement e : linksList) {
				String text1 = e.getText();
				
				if(!(text1.isEmpty())) {
					System.out.println(count + " =  " +   text1);
				}
				count++;
				
			}
		}
	
}
			
			
	
		
	


 