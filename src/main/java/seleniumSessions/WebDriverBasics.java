
package seleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com");

	
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.equals("Google")) {
			System.out.println("title is correct");
		}

		else {
			System.out.println("Incorrect title");
		}
		
		
		String url = driver.getCurrentUrl(); // to get the url
		System.out.println(url);

		
		

		String pgSrce = driver.getPageSource(); // to get the page source----inspect
		System.out.println(pgSrce);

		if (pgSrce.contains("Copyright The Closure")) {

			System.out.println("this info is------------- present");
		}

		else {
			System.out.println("this info is not present");
		}

		
		
		

		driver.close();

	
		System.out.println("edge-------------------------RemoteWebDriver driver3 = new EdgeDriver();------------");

		RemoteWebDriver driver3 = new EdgeDriver(); //top casting
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Java\\msedgedriver.exe");

		driver3.get("https://www.google.com");
		System.out.println("launch Edge browser");

		driver3.close();

	}

}

