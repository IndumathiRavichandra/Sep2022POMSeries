package seleniumSessions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindowConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(10000);

		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.WINDOW);// tab or window option
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}

}
