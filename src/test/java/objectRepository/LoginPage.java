package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DataUtilities;

public class LoginPage {

	DataUtilities du;
	
	//Declaration
	@FindBy(name = "user_name")
	private WebElement usernametextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//Initialization
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		
		du = new DataUtilities();
		String un = du.getDataFromPropertyFile("username");
		usernametextField.sendKeys(un);
	}
	
	public void enterPassword() {
		
		du = new DataUtilities();
		String pwd = du.getDataFromPropertyFile("password");
		passwordTextField.sendKeys(pwd);
	}
	
	public void clickLoginbutton() {
		
		loginBtn.click();
	}
	
	
}
