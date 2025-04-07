package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtilities {

	//Launch browser
	public WebDriver Launchbrowser() {
		
		DataUtilities du = new DataUtilities();
		String browser = du.getDataFromPropertyFile("browser");
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		return driver;
	}
	
	//Passing url
	public void passUrl(WebDriver driver) {
		
		String url = new DataUtilities().getDataFromPropertyFile("url");
		driver.get(url);
	}
	
	//Maximise the browser
	public void maximiseBrowser(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}
	public void pageLoadingWait(WebDriver driver, long time) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	}
	
	public void waitUntilElementClickable(WebDriver driver, long time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	public void titleContains(WebDriver driver, long time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	public void urlContains(WebDriver driver, long time, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.urlContains(url));
		
	}
	
	public void waituntilElementVisible(WebDriver driver, long time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
}
