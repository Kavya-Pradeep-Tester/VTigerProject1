package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class LeadsPage {
	
	@FindBy(xpath = "/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement createLeadsIcon;
	
	@FindBy(name = "salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "company")
	private WebElement companyName;
	
	@FindBy(name = "leadsource")
	private WebElement leadsrcDropDown;
	
	@FindBy(name = "title")
	private WebElement titleTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "annualrevenue")
	private WebElement annualRevenueTextField;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "leadstatus")
	private WebElement leadStatusTextField;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateLeadIcon() {
		createLeadsIcon.click();
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
	
	public void enterCompany(String text) {
		companyName.sendKeys(text);
	}
	
	public void selectLeadSource(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(leadsrcDropDown, text);
	}
	
	public void enterTitle(String text) {
		titleTextField.sendKeys(text);
	}
	
	public void selectIndustry(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleTest(industryDropDown, text);
	}
	
	public void enterAnnualRevenue(String text) {
		annualRevenueTextField.sendKeys(text);
	}
	
	public void enterPhone(String text) {
		phoneTextField.sendKeys(text);
	}
	
	public void enterEmail(String text) {
		emailTextField.sendKeys(text);
	}
	
	public void enterLeadStatus(String text) {
		leadStatusTextField.sendKeys(text);
	}
	

}
