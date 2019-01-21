package jUnitTest;
import pageObject.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AjaxFormSubmitTests {
	private RemoteWebDriver webDriver;
	private AjaxFormSubmit AjaxFormSubmitPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		AjaxFormSubmitPage = new AjaxFormSubmit(webDriver);
		AjaxFormSubmitPage.openViaUrl(AjaxFormSubmit.getUrl());
		AjaxFormSubmitPage.initializeElements(webDriver);
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
	public void inputTextIntoBoxes() throws Exception {
		initializeSettings();
		AjaxFormSubmitPage.nameBoxClick();
		AjaxFormSubmitPage.nameBoxInputText("Daniel");
		AjaxFormSubmitPage.commentBoxClick();
		AjaxFormSubmitPage.commentBoxInputText("Still a newbie.");
		AjaxFormSubmitPage.submitButtonClick();
		Thread.sleep(2000);
		
		Assert.assertEquals("Form submited Successfully!",AjaxFormSubmitPage.getResultMessage().getText());
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
