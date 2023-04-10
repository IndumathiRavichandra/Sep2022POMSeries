package testngSessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {

	
	@Test
	public void searchTest() {

		System.out.println("searchTest");
		int a = 9/3;
	}

	@Test(dependsOnMethods = "searchTest")
	public void addToCartTest() {

		int a = 9/0;
		System.out.println("addToCartTest");
	}

	@Test(dependsOnMethods = "addToCartTest")
		public void paymentTest() {

		System.out.println("paymentTest");
	}

	
	
	
}
