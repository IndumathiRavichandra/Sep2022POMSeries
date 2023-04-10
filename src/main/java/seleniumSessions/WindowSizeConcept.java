package seleniumSessions;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowSizeConcept {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(
				"https://www.orangehrm.com/orangehrm-30-day-trial/?gclid=Cj0KCQjw8e-gBhD0ARIsAJiDsaWZ6A-ll5Tq7f0obAroM0CZUlCx2wIMpFwwR7jMXlVE9KxF5pvm4EUaAmPwEALw_wcB");
		
		
		driver.manage().window().setSize(new Dimension(450,630));
		
		

	}

}
