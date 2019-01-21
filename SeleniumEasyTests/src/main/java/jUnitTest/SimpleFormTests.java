package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObject.*;

public class SimpleFormTests {
	private RemoteWebDriver webDriver;
	private SimpleFormDemo simpleFormPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		simpleFormPage = new SimpleFormDemo(webDriver);
		simpleFormPage.openViaUrl(SimpleFormDemo.getUrl());
		simpleFormPage.initializeElements(webDriver);
	}
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", path);
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	//Tests for Single Input Field section
	@Test
	public void singleInputTest() throws Exception {
		initializeSettings();
		simpleFormPage.messageBoxClick();
		simpleFormPage.messageBoxInputText("Test message");
		simpleFormPage.showMessageButtonClick();
		
		Assert.assertEquals("Test message",simpleFormPage.getResultMessage().getText());
	}
	
	//Tests Two Input Fields section
	@Test
	public void noInputTest() throws Exception {
		initializeSettings();
		simpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("NaN",simpleFormPage.getValueResultMessage().getText());
	}
	
	@Test
	public void twoNumberTest() throws Exception {
		initializeSettings();
		simpleFormPage.valueFieldAClick();
		simpleFormPage.valueFieldAInput("3");
		simpleFormPage.valueFieldBClick();
		simpleFormPage.valueFieldBInput("4");
		simpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("7",simpleFormPage.getValueResultMessage().getText());
	}
	
	@Test
	public void oneNumberTest()throws Exception {
		initializeSettings();
		simpleFormPage.valueFieldAClick();
		simpleFormPage.valueFieldAInput("123");
		simpleFormPage.valueFieldBClick();
		simpleFormPage.valueFieldBInput("test");
		simpleFormPage.valueResultButtonClick();
		
		Assert.assertEquals("NaN",simpleFormPage.getValueResultMessage().getText());
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
