package Asserts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class B {
	SoftAssert s=new SoftAssert();
	@Test
	public void TC_01() {
		s.assertEquals(true, false,"Somethings missing");
		System.out.println("Hi");
		System.out.println("Hi");
		System.out.println("Hi");
		System.out.println("Hi");
		System.out.println("Hi");
		s.assertAll();
	}
	@Test
	public void TC_02() {
		String s="Shashank Bharadiya";
		Assert.assertTrue(s.contains("Akshay"),"No match found");
	}
}
