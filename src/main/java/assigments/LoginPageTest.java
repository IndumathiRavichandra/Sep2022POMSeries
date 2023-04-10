package assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());
		brUtil.screenMax();

		By newCusTagHeader = By.tagName("h2");
		By fpConLink= By.linkText("Continue");
		By fName = By.name("firstname");
		By lName = By.id("input-lastname");
		By email = By.cssSelector("#input-email");
		By telep = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdConfirm = By.id("input-confirm");
		By pPolicyDot = By.name("agree");
		By contLink = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By headerAccPag = By.tagName("h1");
		
		//partialLinkText
		//driver.findElement(By.partialLinkText("")).click();
		
		//tagName
		//String header = driver.findElement(By.tagName("h2")).getText(); //Tag name can be duplicated 99pct 
		//System.out.println(header);
		
		ElementUtil eleUtil = new ElementUtil(driver);
		String h2 = eleUtil.doGetText(newCusTagHeader);
		System.out.println(h2);
		eleUtil.doClick(fpConLink);
		eleUtil.doSendKeys(fName, "Indu");
		eleUtil.doSendKeys(lName, "r");
		eleUtil.doSendKeys(email, "sdfssdfsdgsffd@test.com");
		eleUtil.doSendKeys(telep, "1234789590");
		eleUtil.doSendKeys(pwd, "Test@123");
		eleUtil.doSendKeys(pwdConfirm, "Test@123");
		eleUtil.doClick(pPolicyDot);
		eleUtil.doClick(contLink);
		
		String accPagHeader = eleUtil.doGetText(headerAccPag);
		System.out.println(accPagHeader);
		
		if(accPagHeader.equals("Your Account Has Been Created!")) {
			System.out.println("Account has created in the right page ");
		}
		
		else {
			System.out.println("Launched page is incorrect ");
		}
			

		//brUtil.Quit();
		//brUtil.closeBrowser();

	} 

}
