package seleniumSessions;

public class XpathAxes{
	
	public static String getXpath(String headerName) {
		
		String xpath = "//div[text()='"+headerName+"']//button[@class='btn btn-link dropdown-toggle']/following-sibling::ul";
		System.out.println(xpath);	
		return xpath;

	}

	public static void main(String[] args) {
		
		getXpath("btn-group");
				
		}

	}


