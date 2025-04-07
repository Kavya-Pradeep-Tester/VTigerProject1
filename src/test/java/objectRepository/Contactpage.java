package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class Contactpage {
	
	//Declaration
	@FindBy(xpath = "/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement createContactIcon;
	
	@FindBy(name = "salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "leadsource")
	private WebElement leadsrcDropDown;
	
	@FindBy(name = "title")
	private WebElement titleTextField;
	
	@FindBy(name = "department")
	private WebElement departmentTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(xpath = "(//input[@title = 'Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//input[@title = 'Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;
	
	//initialization
	
	public Contactpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public void clickCreateContactIcon() {
		createContactIcon.click();
	}
	
	public void selectSalutation(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(salutationDropDown, text);
	}
	
	public void enterFirstName(String text) {
		firstNameTextField.sendKeys(text);
	}
	
	public void enterlastname(String text) {
		lastNameTextField.sendKeys(text);
	}
	
	public void selectLeadSrc(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(leadsrcDropDown, text);
	}
	
	public void enterTitle(String text) {
		titleTextField.sendKeys(text);
	}
	
	public void enterDepatment(String text) {
		departmentTextField.sendKeys(text);
	}
	
	public void enterEmail(String text) {
		emailTextField.sendKeys(text);
	}
	
	public void enterMobile(String text) {
		mobileTextField.sendKeys(text);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	

}
