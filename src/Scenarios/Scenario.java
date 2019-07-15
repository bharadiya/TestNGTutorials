package Scenarios;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario {
	@Test
	private void third() {
		System.out.println("third");
	}

	@Test
	private void second() {
		System.out.println("second");
	}

	/*
	 * @Test public void first() { System.out.println("first"); }
	 * 
	 * @BeforeMethod public void beforemethod() {
	 * System.out.println("before method"); }
	 * 
	 * @AfterMethod public void afterdmethod() { System.out.println("aftermethod");
	 * }
	 * 
	 * @BeforeMethod public void beforedmethod() {
	 * System.out.println("before method 2"); }
	 * 
	 * @AfterMethod public void aftermethod() { System.out.println("aftermethod 1");
	 * }
	 */
	@BeforeClass
	public void beforeclass() {
		System.out.println("before class");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("after class");
	}

	/*
	 * @BeforeClass public void beforefclass() {
	 * System.out.println("before class 2"); }
	 * 
	 * @AfterClass public void afterfclass() { System.out.println("after class 2");
	 * }
	 * 
	 * @BeforeSuite public void beforesuite() { System.out.println("before suite");
	 * }
	 * 
	 * @AfterSuite public void aftersuite() { System.out.println("after suite"); }
	 * 
	 * @BeforeSuite public void beforefsuite() {
	 * System.out.println("before suite 2"); }
	 * 
	 * @AfterSuite public void afterfsuite() { System.out.println("after suite 2");
	 * }
	 * 
	 * @BeforeTest public void beforetest() { System.out.println("before test"); }
	 * 
	 * @AfterTest public void afterTest() { System.out.println("afterTest"); }
	 * 
	 * @BeforeTest public void beforetfest() { System.out.println("before test 2");
	 * }
	 * 
	 * @AfterTest public void afterfTest() { System.out.println("afterTest 2"); }
	 */}
