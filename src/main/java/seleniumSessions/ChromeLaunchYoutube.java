package seleniumSessions;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeLaunchYoutube {

	public static void main(String[] args) {
		
		/*
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("Google")) {
			System.out.println("title is correct");
		}

		else {
			System.out.println("Incorrect title");
		}

		driver.close();
*/
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com"); // to launch the url
		
		String url = driver.getCurrentUrl(); // to get the url
		System.out.println(url);
		String pgSrce = driver.getPageSource(); // to get the page source----inspect

		System.out.println(pgSrce);
		
		if(pgSrce.contains("Copyright The Closure")) {
			
			System.out.println("this info is------------- present");
		}
		
		else {
			System.out.println("this info is not present");
		}
		
		
	
	}

}
