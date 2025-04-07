package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class Scenario1 extends BaseClass{
	
	@Test(groups = "adhoc")
	public void moveToLeadpage() {
		hp.clickLeadsLink();
		System.out.println("adhoc1");
	}
	
	@Test(groups = "adhoc")
	public void moveToOrganizationPage() {
		hp.clickOrganizationLink();
		System.out.println("adhoc2");
	}


}
