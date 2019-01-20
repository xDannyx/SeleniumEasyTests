package jUnitTest;

import java.util.concurrent.TimeUnit;
import pageObject.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptAlertsTests {
	private RemoteWebDriver webDriver;
	private JavaScriptAlerts JavaScriptAlertsPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		JavaScriptAlertsPage = new JavaScriptAlerts(webDriver);
		JavaScriptAlertsPage.openViaUrl(JavaScriptAlerts.getUrl());
		JavaScriptAlertsPage.initializeElements(webDriver);
	}
	
	public void acceptAlert() {
		Alert alert = webDriver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissAlert() {
		Alert alert = webDriver.switchTo().alert();
		alert.dismiss();
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
	public void confirmAlertBox() throws Exception {
		initializeSettings();
		JavaScriptAlertsPage.submitButtonSection1Click();
		Thread.sleep(2000);
		acceptAlert();
	}
	
	@Test
	public void confirmPopupBox() throws Exception {
		initializeSettings();
		JavaScriptAlertsPage.submitButtonSection2Click();
		Thread.sleep(2000);
		acceptAlert();
		
		Assert.assertEquals("You pressed OK!",JavaScriptAlertsPage.getResultMessageSection2().getText());
	}
	
	@Test
	public void dismissPopupBox() throws Exception {
		initializeSettings();
		JavaScriptAlertsPage.submitButtonSection2Click();
		Thread.sleep(2000);
		dismissAlert();
		
		Assert.assertEquals("You pressed Cancel!",JavaScriptAlertsPage.getResultMessageSection2().getText());
	}
	
	@Test
	public void inputPopupBox() throws Exception {
		initializeSettings();
		JavaScriptAlertsPage.submitButtonSection3Click();
		webDriver.switchTo().alert().sendKeys("Better than newbie");
		Thread.sleep(2000);
		acceptAlert();
		
		Assert.assertEquals("You have entered 'Better than newbie' !",JavaScriptAlertsPage.getResultMessageSection3().getText());
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(2000);
		webDriver.close();
		webDriver.quit();
	}
}
