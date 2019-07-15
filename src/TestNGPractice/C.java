package TestNGPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class C {

	

	@AfterSuite
	public void afterfsuite() {
		System.out.println("after suite 2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@AfterTest
	public void afterfTest() {
		System.out.println("afterTest 2");
	}
}
