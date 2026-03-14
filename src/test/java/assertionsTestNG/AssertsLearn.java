package assertionsTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertsLearn {

	@Test
	public void asserttestdata() {
		int a = 10, b= 10, c= a+b;
		Assert.assertEquals(c, 21);
	}
}
