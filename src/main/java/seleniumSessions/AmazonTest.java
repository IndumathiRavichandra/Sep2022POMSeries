package seleniumSessions;

//import java.net.URL;

//import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {

		String browserName = "chrome";
		BrowserUtil brutil = new BrowserUtil();
		brutil.launchBrowser(browserName);

//		driver.get("http://www.amazon.com");

		brutil.launchUrl("http://www.amazon.com");
		//driver.navigate().to(new URL("http://www.amazon.com"));
//		String url = driver.getCurrentUrl();
//		System.out.println(url);

//		String title = driver.getTitle();

		String title = brutil.getPageTitle();

		// validation always in main test
		System.out.println("title is " + title);
		if (title.contains("Amazon")) {

			System.out.println("Correct title");
		}

		else {
			System.out.println("InCorrect title");
		}

//		 driver.quit();

		brutil.closeBrowser();
	}

}
