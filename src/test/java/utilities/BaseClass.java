package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import objectRepository.Contactpage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

@Listeners(ListenersClass.class)
public class BaseClass {
	
	public static WebDriver sdriver;
	
	public WebDriver driver;
	public WebDriverUtilities wu;
	public LoginPage lp;
	public HomePage hp;
	public Contactpage cp;
	public OrganizationPage op;
	
	
	@BeforeMethod(alwaysRun = true)
	public void login() {
		
		wu = new WebDriverUtilities();
		
		driver = wu.Launchbrowser();
		
		sdriver = driver;
		
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cp = new Contactpage(driver);
		op = new OrganizationPage(driver);
		
		wu.maximiseBrowser(driver);
		wu.implicitwait(driver, 10);
		wu.pageLoadingWait(driver, 50);
		
		wu.passUrl(driver);
		
		lp.enterUsername();
		lp.enterPassword();
		lp.clickLoginbutton();
		
	}
	
	@AfterMethod
	public void logout() {
		
		hp = new HomePage(driver);
		hp.signout(driver);
		wu.closeBrowser(driver);
	}

}
