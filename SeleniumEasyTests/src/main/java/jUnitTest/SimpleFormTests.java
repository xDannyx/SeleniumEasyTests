package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObject.*;

public class SimpleFormTests {
	private RemoteWebDriver webDriver;
	private SimpleFormDemo SimpleFormPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		SimpleFormPage = new SimpleFormDemo(webDriver);
		SimpleFormPage.openViaUrl(SimpleFormDemo.getUrl());
		SimpleFormPage.initializeElements(webDriver);
	}
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", path);
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
//		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
//		jse.executeScript("scroll(0,3000)", "");
		Thread.sleep(3000);
	}
	
	//Tests for Single Input Field section
	@Test
	public void singleInputTest() throws Exception {
		initializeSettings();
		SimpleFormPage.messageBoxClick();
		SimpleFormPage.messageBoxInputText("Test message");
		SimpleFormPage.showMessageButtonClick();
		
		Assert.assertEquals("Test message",SimpleFormPage.getResultMessage().getText());
	}
	
	//Tests Two Input Fields section
	@Test
	public void noInputTest() throws Exception {
		initializeSettings();
		SimpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("NaN",SimpleFormPage.getValueResultMessage().getText());
	}
	
	@Test
	public void twoNumberTest() throws Exception {
		initializeSettings();
		SimpleFormPage.valueFieldAClick();
		SimpleFormPage.valueFieldAInput("3");
		SimpleFormPage.valueFieldBClick();
		SimpleFormPage.valueFieldBInput("4");
		SimpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("7",SimpleFormPage.getValueResultMessage().getText());
	}
	
	@Test
	public void oneNumberTest()throws Exception {
		initializeSettings();
		SimpleFormPage.valueFieldAClick();
		SimpleFormPage.valueFieldAInput("123");
		SimpleFormPage.valueFieldBClick();
		SimpleFormPage.valueFieldBInput("test");
		SimpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("NaN",SimpleFormPage.getValueResultMessage().getText());
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
