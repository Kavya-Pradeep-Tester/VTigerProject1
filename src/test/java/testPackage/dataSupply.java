package testPackage;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DataUtilities;

public class dataSupply {

	
	@DataProvider (name = "ContactDetails")
	public Object[][] databaseContacts(){
		DataUtilities du = new DataUtilities();
		
		ArrayList<Object[]> result = du.getDataFromDatabase("select * from contacts");
		return result.toArray(new Object[0][]);
	}
	
	@Test(dataProvider = "ContactDetails", dataProviderClass = dataSupply.class)
	public void contactDetails(String salutation, String firstname,String lastname, String leadsrc, String title, String department, String email, String mobile ) {
		
	}
	


	}
