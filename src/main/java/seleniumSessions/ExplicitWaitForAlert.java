package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForAlert {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		// Alert-----waiting for the alert and switching to the alert also
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();
		
		waitForAlertPresentAndSwitch(30);
		String text = getAlertText(10);
		System.out.println(text);
		acceptAlert(10);

	}

	public static Alert waitForAlertPresentAndSwitch(int timeOut) {// Exact title

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public static String getAlertText(int timeOut) {
		return waitForAlertPresentAndSwitch(timeOut).getText();

	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlertPresentAndSwitch(timeOut).accept();

	}
	public static void dismissAlert(int timeOut) {
		waitForAlertPresentAndSwitch(timeOut).dismiss();

	}
	public static void alertSendKeys(int timeOut, String value) {
		waitForAlertPresentAndSwitch(timeOut).sendKeys(value);

	}
}
