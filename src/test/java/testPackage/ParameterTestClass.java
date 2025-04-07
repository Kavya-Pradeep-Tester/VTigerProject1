package testPackage;

import org.testng.annotations.Test;

public class ParameterTestClass {

	@Test
	public void getDataFrommaven() {

		System.out.println(System.getProperty("sample"));
		System.out.println(System.getProperty("password"));
	}
}
