package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.*;

public class BasicCheckboxTests {
	private RemoteWebDriver webDriver;
	private BasicCheckboxDemo CheckboxPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		CheckboxPage = new BasicCheckboxDemo(webDriver);
		CheckboxPage.openViaUrl(BasicCheckboxDemo.getUrl());
		CheckboxPage.initializeElements(webDriver);
	}
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", path);
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void checkSingleBox() throws Exception {
		initializeSettings();
		CheckboxPage.singleCheckboxClick();
		
		Assert.assertEquals("Success - Check box is checked",CheckboxPage.getResultMessage().getText());
	}
	
	@Test
	public void checkThenUncheckAll() throws Exception {
		initializeSettings();
		CheckboxPage.checkButtonClick();
		Thread.sleep(1000);
		CheckboxPage.checkButtonClick();
	}
	
	@Test
	public void checkEveryoneUncheckCheckAll() throws Exception {
		initializeSettings();
		CheckboxPage.checkOption1Click();
		Thread.sleep(1000);
		CheckboxPage.checkOption2Click();
		Thread.sleep(1000);
		CheckboxPage.checkOption3Click();
		Thread.sleep(1000);
		CheckboxPage.checkOption4Click();
		Thread.sleep(1000);
		CheckboxPage.checkButtonClick();
		Thread.sleep(1000);
		CheckboxPage.checkButtonClick();
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
