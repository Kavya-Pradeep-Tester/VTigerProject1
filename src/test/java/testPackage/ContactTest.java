package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class ContactTest extends BaseClass{

	
	@Test(dataProvider = "ContactDetails", dataProviderClass = dataSupply.class)
	public void createContact(String salutation, String firstname,String lastname, String leadsrc, String title, String department, String email, String mobile) {
		
		hp.clickContactsLink();
		cp.clickCreateContactIcon();
		cp.selectSalutation(salutation);
		cp.enterFirstName(firstname);
		cp.enterlastname(lastname);
		cp.selectLeadSrc(leadsrc);
		cp.enterTitle(title);
		cp.enterDepatment(department);
		cp.enterEmail(email);
		cp.enterMobile(mobile);
		cp.clickSaveButton();
		
	}
	
	
}
