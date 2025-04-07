package testPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	@Parameters({"browser", "username", "password", "inte" })
	@Test(enabled = false)
	public void testCase4(String browser, String username1, String password, int value) {
		
		System.out.println(browser);
		System.out.println(username1);
		System.out.println(password);
		System.out.println(value);
	}
}
