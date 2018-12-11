package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadioButtonsDemo extends BasePage {
	private String url="https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
	protected RemoteWebDriver wb;
	
	public RadioButtonsDemo(RemoteWebDriver wb) {
		super(wb);
	}
	
	public String getUrl() {
		return url;
	}
	
	//elements for Radio Button Demo section
	private WebElement maleRB;
	private WebElement femaleRB;
	private WebElement checkButton;
	private WebElement resultMessage;
	
	//elements for Group Radio Buttons Demo section
	private WebElement maleGRB;
	private WebElement femaleGRB;
	private WebElement zeroToFiveGRB;
	private WebElement fiveToFifeteenGRB;
	private WebElement fifeteenToFiftyGRB;
	
	//methods for Radio Button Demo section
	//
	
	//methods for Group Radio Buttons Demo section
	//
	
	//initialization of all elements from both sections
	//
}
