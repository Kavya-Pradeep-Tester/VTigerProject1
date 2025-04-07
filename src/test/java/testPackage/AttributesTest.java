package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class AttributesTest extends BaseClass{

	@Test(groups = "smoke")
	public void moveToLeadspage() {
		hp.clickLeadsLink();
		System.out.println("Smoke2");
	}
	
	@Test(groups = "smoke")
	public void moveToOrganizationPage() {
		hp.clickOrganizationLink();
		System.out.println("Smoke1");
		System.out.println("Adding changes and push to Git");
	}
	
	@Test(groups = "integration")
	public void moveToContactsPage() {
		hp.clickContactsLink();
		System.out.println("integration1");
	}
	
	@Test(groups = "integration")
	public void moveToCalenderPage() {
		hp.clickCalenderLink();
		System.out.print("integration2");
	}
	
	@Test()
	public void moveToCalenderPage2() {
		hp.clickCalenderLink();
		
		System.out.print("sample");
	}
}
