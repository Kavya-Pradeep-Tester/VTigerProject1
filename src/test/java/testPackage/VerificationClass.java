package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationClass {

	@Test
	public void veriication() {
		Assert.assertEquals(false, false);
		Assert.assertEquals(5, 5);
		Assert.assertEquals("Kavya", "Kavya");
		
		Assert.assertNotEquals(true, false);
		Assert.assertNotEquals(7, 3);
		
		Assert.assertNull(null);
		Assert.assertNotNull("Hari");
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		//Assert.fail();
	}
}
