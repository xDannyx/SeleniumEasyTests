package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleFormDemo extends BasePage {
	private final static String Url = mainUrl + "basic-first-form-demo.html";
	
	public SimpleFormDemo(RemoteWebDriver webDriver) {
		super(webDriver);
	}
	
	public static String getUrl() {
		return Url;
	}
	
	//elements for Single Input Field section
	private WebElement messageBox;
	private WebElement showMessageButton;
	private WebElement resultMessage;
	
	//elements for Two Input Fields section
	private WebElement valueFieldA;
	private WebElement valueFieldB;
	private WebElement valueResultButton;
	private WebElement valueResultMessage;
	
	//methods for Single Input Field section
	public SimpleFormDemo messageBoxClick() {
		messageBox.click();
		return this;
	}
	
	public SimpleFormDemo messageBoxInputText(String inputText) {
		messageBox.sendKeys(inputText);
		return this;
	}
	
	public SimpleFormDemo showMessageButtonClick() {
		showMessageButton.click();
		return this;
	}
	
	public WebElement getResultMessage() {
		return resultMessage;
	}
	
	//methods for Two Input Fields section
	public SimpleFormDemo valueFieldAClick() {
		valueFieldA.click();
		return this;
	}
	
	public SimpleFormDemo valueFieldAInput(String inputValueA) {
		valueFieldA.sendKeys(inputValueA);
		return this;
	}
	
	public SimpleFormDemo valueFieldBClick() {
		valueFieldB.click();
		return this;
	}
	
	public SimpleFormDemo valueFieldBInput(String inputValueB) {
		valueFieldB.sendKeys(inputValueB);
		return this;
	}
	
	public SimpleFormDemo valueResultButtonClick() {
		valueResultButton.click();
		return this;
	}
	
	public WebElement getValueResultMessage() {
		return valueResultMessage;
	}
	
	public SimpleFormDemo initializeElements(RemoteWebDriver webDriver) {
		messageBox = webDriver.findElement(By.xpath("//*[@id=\"user-message\"]"));
		showMessageButton = webDriver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
		resultMessage = webDriver.findElement(By.xpath("//*[@id=\"display\"]"));
		valueFieldA = webDriver.findElement(By.xpath("//*[@id=\"sum1\"]"));
		valueFieldB = webDriver.findElement(By.xpath("//*[@id=\"sum2\"]"));
		valueResultButton = webDriver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
		valueResultMessage = webDriver.findElement(By.xpath("//*[@id=\"displayvalue\"]"));
		return this;
	}
	
}
