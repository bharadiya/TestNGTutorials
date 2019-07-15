package Asserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A {
	@Test
	private void m1() {
		Assert.assertEquals(12, 14);
	}

	@Test
	private void m2() {
		System.out.println("Test case m2 started");
		Assert.assertEquals(12, 14, "Please check with the developer ");
		System.out.println("Test case m2 ends here");
	}

	@Test
	private void m3() {
		System.out.println("Test case m3 started");
		Assert.assertEquals("hello", "hello", "words does not match please raise a bug");
		System.out.println("Test case m3 ended");
	}
}
