package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthPopHandle {
	static WebDriver driver;

	public static boolean doLogin(String username, String password, String url) throws InterruptedException {

		driver.get("https://" + username + ":" + password + "@" + url);
		WebElement contentLocator = driver.findElement(By.xpath("//div[@id='content']//p"));

		String text = contentLocator.getText();

		if (text.contains("Congratulations")) {
			return true;
		}

		else {

			return false;
		}

	}

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		// driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		if (doLogin("admin", "admin", "the-internet.herokuapp.com/basic_auth")) {

			System.out.println("Login Successful");
		}

		else {

			System.out.println("Login Not Successful");

		}

	}

}
