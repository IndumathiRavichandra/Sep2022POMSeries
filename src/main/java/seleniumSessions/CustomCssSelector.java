package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomCssSelector {
	
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		driver.findElement(By.cssSelector("#input-email")).sendKeys("sdfassdf@gmail.com"); // #id
		driver.findElement(By.cssSelector("input.form-control#input-password")).sendKeys("ssagh123");//htmltag  .class   #id
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();//htmltag  .class   .class
//		//              input[type='submit'][value='Login']--------css
		//				//input[@type='submit' and @value='Login']--------xpath
		
		
		By mand_elements =By.cssSelector("input#input-email,input#input-password,input.btn.btn-primary");
		
		int mand_elements_count =   driver.findElements(mand_elements).size();
		
		if (mand_elements_count==3) {
			
			System.out.println("All present");
			
		}
		else {
			System.out.println("incorrect");
			
		}
			
	}

}
