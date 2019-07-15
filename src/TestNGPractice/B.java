package TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B extends C {
	@Test
	public void first() {
		System.out.println("first");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method");
	}

	@AfterMethod
	public void afterdmethod() {
		System.out.println("aftermethod");
	}

	@BeforeMethod
	public void beforedmethod() {
		System.out.println("before method 2");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod 1");
	}

	
	
	@AfterClass
	public void afterclass() {
		System.out.println("after class");
	}

	@AfterClass
	public void afterfclass() {
		System.out.println("after class 2");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}


}
