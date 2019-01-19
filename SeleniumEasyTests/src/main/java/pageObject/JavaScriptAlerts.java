package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptAlerts extends BasePage {
	private final static String Url = mainUrl + "javascript-alert-box-demo.html";
	
	public JavaScriptAlerts(RemoteWebDriver webDriver) {
		super(webDriver);
	}
	
	public static String getUrl() {
		return Url;
	}
	
	//elements for Java Script Alert Box section
	private WebElement submitButtonSection1; 
	
	//elements for Java Script Confirm Box section
	
	
	//elements for Java Script Alert Box section
	
	
	//methods for Java Script Alert Box section
	public JavaScriptAlerts submitButtonSection1Click() {
		submitButtonSection1.click();
		return this;
	}
	
	//methods for Java Script Confirm Box section
	
	
	//methods for Java Script Alert Box section
	
	
	
	public JavaScriptAlerts initializeElements(RemoteWebDriver webDriver) {
		submitButtonSection1 = webDriver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button"));
		return this;
	}
}
