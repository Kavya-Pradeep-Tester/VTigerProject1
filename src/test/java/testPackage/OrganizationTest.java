package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrganizationTest extends BaseClass	{
	
	@Test
	public void createOrganization() {
		
		hp.clickOrganizationLink();
		op.clickCreateOrganizationIcon();
		op.enterCompanyName(System.getProperty("orgName"));
		op.enterEmployeesCount("100");
		op.enterIndustryDropDown("Engineering");
		op.selectAccountType("Partner");
		op.enterPhone(System.getProperty("num"));
		op.enterEmail("cognizent@gmail.com");
		op.clickSaveButton();
	}
	
}
