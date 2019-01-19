package jUnitTest;

import java.util.concurrent.TimeUnit;
import pageObject.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptAlertsTests {
	private RemoteWebDriver webDriver;
	private JavaScriptAlerts JavaScriptAlertsPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	Alert alert = webDriver.switchTo().alert();
	
	public void initializeSettings() {
		JavaScriptAlertsPage = new JavaScriptAlerts(webDriver);
		JavaScriptAlertsPage.openViaUrl(JavaScriptAlerts.getUrl());
		JavaScriptAlertsPage.initializeElements(webDriver);
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
	public void confirmPopupAlert() throws Exception {
		initializeSettings();
		JavaScriptAlertsPage.submitButtonSection1Click();
		Thread.sleep(2000);
		alert.accept();
	}
	
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
