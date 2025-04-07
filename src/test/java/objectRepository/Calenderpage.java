package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calenderpage {

	@FindBy(className = "calAddButton")
	private WebElement addButton;
	
	@FindBy(id = "addcall")
	private WebElement addCallbutton;
	
	@FindBy (id = "addmeeting")
	private WebElement addMeetingButton;
	
	@FindBy(name = "activitytype")
	private WebElement addType;
	
	@FindBy(name="subject")
	private WebElement addEventName;
}
