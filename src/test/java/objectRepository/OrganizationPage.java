package objectRepository;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class OrganizationPage {

	//Declaration
	@FindBy (xpath = "/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement createOrganizationIcon;

	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name = "employees")
	private WebElement employeesTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement accountTypeDropDown;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(name = "email1")
	private WebElement emailTextField;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelbutton;
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public void clickCreateOrganizationIcon() {
		createOrganizationIcon.click();
	}
	
	public void enterCompanyName(String text) {
		organizationNameTextField.sendKeys(text);
	}
	
	public void enterEmployeesCount(String text) {
		employeesTextField.sendKeys(text);
	}
	
	public void enterIndustryDropDown(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(industryDropDown, text);
	}
	
	public void selectAccountType(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(accountTypeDropDown, text);
	}
	
	public void enterPhone(String number) {
		phoneTextField.sendKeys(number);
	}
	
	public void enterEmail(String text) {
		emailTextField.sendKeys(text);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickCancelButton() {
		cancelbutton.click();
	}
}
