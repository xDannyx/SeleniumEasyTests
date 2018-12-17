package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadioButtonsDemo extends BasePage {
	private static String url="https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
	protected RemoteWebDriver wb;
	
	public RadioButtonsDemo(RemoteWebDriver wb) {
		super(wb);
	}
	
	public static String getUrl() {
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
	public RadioButtonsDemo maleRBClick() {
		maleRB.click();
		return this;
	}
	
	public RadioButtonsDemo femaleRBClick() {
		femaleRB.click();
		return this;
	}
	
	public RadioButtonsDemo checkButtonClick() {
		checkButton.click();
		return this;
	}
	
	public WebElement getResultMessage() {
		return resultMessage;
	}
	
	//methods for Group Radio Buttons Demo section
	//
	
	//initialization of all elements from both sections
	public RadioButtonsDemo initializeElements(RemoteWebDriver wd) {
		maleRB = wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
		femaleRB = wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
		checkButton = wb.findElement(By.id("buttoncheck"));
		resultMessage = wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));
		return this;
	}
}
