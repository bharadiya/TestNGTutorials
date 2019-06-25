package B;

import org.testng.annotations.Test;

public class B {
	 @Test(dependsOnGroups={"verifyConfig"})
	public void depend() {
		// TODO Auto-generated method stub
		System.out.println("depends on A");
	}
}
