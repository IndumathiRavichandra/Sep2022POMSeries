package testngSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	String name;

	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void calTest() {
		
		System.out.println("cal Test");
		//int a = 9/0;
		
		
		ExpectedExceptionConcept obj = null;
		obj.name = "Tom";
		
	}

}
