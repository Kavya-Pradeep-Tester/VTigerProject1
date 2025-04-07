package utilities;

import java.awt.Robot;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtilities {
	
	public void selectOptionIndexByIndex(WebElement element, int index) {
		
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectOptionByValue(WebElement element,String value ) {
		
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void selectOptionByVisibleTest(WebElement element, String value) {
		
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public void deSelectOptionByIndex(WebElement element, int value) {
		
		Select s = new Select(element);
		s.deselectByIndex(value);
	}
	
	public void deSelectOptionByValue(WebElement element,String value ) {
		
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	public void deSelectOptionByVisibleText(WebElement element, String value) {
		
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}
	
	public void deSelectAllOptions(WebElement element) {
		
		Select s = new Select(element);
		s.deselectAll();
	}
	
	public void getAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());

		}
	}

	public void getSelectedOptions(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.getFirstSelectedOption().getText());

	}

	public void getFirstOption(WebElement element) {
		
		Select s = new Select (element);
		System.out.println(s.getFirstSelectedOption().getText());
	}
	
	public void verifyDropdownIsMultiple(WebElement element) {
		
		Select s = new Select(element);
		System.out.println(s.isMultiple()?"Dropdown is multi select":"Dropdown is single select");
	}
	 
	public void mouseHoverOn(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseHoverTo(WebDriver driver, WebElement element, int x, int y) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();;
	}
	
	public void clickAndHoldElement(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void releaseElement(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, WebElement src, WebElement dst) {
		
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	
	public void dragAndDropElementBy(WebDriver driver, WebElement src, int x, int y) {
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y);
	}

	public void doubleClickButton(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClickButton(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void pressKey(int keycode) {
		
		try {
			
			Robot robot = new Robot();
			robot.keyPress(keycode);
		}catch(Exception e) {
			
			System.out.println("Unable to press the key");
		}
	}
	
	public void releasekey(int keycode) {
		
		try {
			
			Robot robot = new Robot();
			robot.keyRelease(keycode);
		}catch (Exception e) {
			
			System.out.println("Unable to release the key");
		}
	}
	
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	public void dissmissAlert(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	
	public void passDataToAlert(WebDriver driver, String text) {
		
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void getAlertMessage(WebDriver driver) {
		
		driver.switchTo().alert().getText();
	}
	
	public void switchControlToNewTab(WebDriver driver) {
		
		String pid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		
		for(String id:allid) {
			if(!id.equals(pid)) {
				driver.switchTo().window(id);
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
	}
	
	public void switchToParentFrame(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
	
	public void switchToWebPage(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	public void passTheDataToTextFieldUsingJSE(WebDriver driver, String id, String value) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').value="+value);
	}
	
	public void clickRadioButtonUsingJSE(WebDriver driver, String id, String value) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').checked=true");
	}

	public void checkTheChecBoxFieldUsingJSE(WebDriver driver, String id, String value) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('"+id+"').checked=true");
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void scroll(WebDriver driver, int x, int y) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public String currentDate() {
		
		return new Date().toString().replaceAll(":", "_").replaceAll(" ","_");
	}
	
	public String captureScreenShot(WebDriver driver, String path) {
		
		File dst;
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			dst = new File(path);
			Files.copy(src, dst);
			System.out.println("Screenshot captured succussfully");
		}catch (Exception e) {
			System.out.println("Unable to capture screenshot");
		}
		return path;
	}
}
