package jUnitTest;

import java.util.concurrent.TimeUnit;
import pageObject.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BootstrapModalTests {
	private RemoteWebDriver webDriver;
	private BootstrapModal BootstrapPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		BootstrapPage = new BootstrapModal(webDriver);
		BootstrapPage.openViaUrl(BootstrapModal.getUrl());
		BootstrapPage.initializeElements(webDriver);
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
	public void saveFirstModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection1Click();
		Thread.sleep(2000);
		BootstrapPage.saveChangesSection1Click();
	}
	
	@Test
	public void closeFirstModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection1Click();
		Thread.sleep(2000);
		BootstrapPage.closeSection1Click();
	}
	
	@Test
	public void saveSecondModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection2Click();
		Thread.sleep(2000);
		BootstrapPage.saveChangesSection2Click();
	}
	
	@Test
	public void closeSecondModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection2Click();
		Thread.sleep(2000);
		BootstrapPage.closeSection2Click();
	}
	
	@Test
	public void saveThirdModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection2Click();
		Thread.sleep(2000);
		BootstrapPage.launchSection3Click();
		Thread.sleep(2000);
		BootstrapPage.saveChangesSection3Click();
	}
	
	@Test
	public void closeThirdModal() throws Exception {
		initializeSettings();
		BootstrapPage.launchSection2Click();
		Thread.sleep(2000);
		BootstrapPage.launchSection3Click();
		Thread.sleep(2000);
		BootstrapPage.closeSection3Click();
		Thread.sleep(2000);
		BootstrapPage.closeSection2Click();
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(2000);
		webDriver.close();
		webDriver.quit();
	}
}
