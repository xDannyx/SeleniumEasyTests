package jUnitTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObject.AjaxSubmitWithLoading;

public class AjaxSubmitWithLoadingTests {
	private RemoteWebDriver webDriver;
	private AjaxSubmitWithLoading ajaxFormSubmitwithLoadingPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		ajaxFormSubmitwithLoadingPage = new AjaxSubmitWithLoading(webDriver);
		ajaxFormSubmitwithLoadingPage.openViaUrl(AjaxSubmitWithLoading.getUrl());
		ajaxFormSubmitwithLoadingPage.initializeElements(webDriver);
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
	public void submitForm() throws Exception {
		initializeSettings();
		ajaxFormSubmitwithLoadingPage.nameBoxInputText("Daniel");
		ajaxFormSubmitwithLoadingPage.commentBoxInputText("Still a newbie.");
		ajaxFormSubmitwithLoadingPage.submitButtonClick();
		Thread.sleep(2000);
		
		Assert.assertEquals("Form submited Successfully!",ajaxFormSubmitwithLoadingPage.getResultMessage().getText());
		//Assert.assertFalse(ajaxFormSubmitwithLoadingPage.getSubmitButton().isDisplayed());
	}
	
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
