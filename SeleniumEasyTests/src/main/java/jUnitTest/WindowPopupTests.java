package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.*;
public class WindowPopupTests {
	private RemoteWebDriver webDriver;
	private WindowPopupExample WindowPopupPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	//String winHandleBefore = webDriver.getWindowHandle();
	
	public void initializeSettings() {
		WindowPopupPage = new WindowPopupExample(webDriver);
		WindowPopupPage.openViaUrl(WindowPopupExample.getUrl());
		WindowPopupPage.initializeElements(webDriver);
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
	public void openTwitterThenClose() throws Exception {
		String winHandleBefore = webDriver.getWindowHandle();
		initializeSettings();
		WindowPopupPage.followTwitterButtonClick();
		for(String winHandle : webDriver.getWindowHandles()){
			webDriver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore);
	}
	
	@Test
	public void openFacebookThenClose() throws Exception {
		String winHandleBefore = webDriver.getWindowHandle();
		initializeSettings();
		WindowPopupPage.likeFacebookButtonClick();
		for(String winHandle : webDriver.getWindowHandles()){
			webDriver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore);
	}
	
//	@Test
//	public void openTwitterAndFacebookThenClose() throws Exception {
//		String winHandleBefore = webDriver.getWindowHandle();
//		initializeSettings();
//		WindowPopupPage.followTwitterAndFacebookButtonClick();
//		for(String winHandle : webDriver.getWindowHandles()){
//			webDriver.switchTo().window(winHandle);
//			Thread.sleep(2000);
//			webDriver.close();
//		}
//		Thread.sleep(2000);
//		webDriver.close();
//		webDriver.switchTo().window(winHandleBefore);
//	}
//	
//	@Test
//	public void openAllThenClose() throws Exception {
//		String winHandleBefore = webDriver.getWindowHandle();
//		initializeSettings();
//		WindowPopupPage.followAllButtonClick();
//		for(String winHandle : webDriver.getWindowHandles()){
//			webDriver.switchTo().window(winHandle);
//			Thread.sleep(2000);
//			webDriver.close();
//		}
//		Thread.sleep(2000);
//		webDriver.close();
//		webDriver.switchTo().window(winHandleBefore);
//	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
