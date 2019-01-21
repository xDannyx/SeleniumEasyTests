package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.*;
public class FileDownloadTests {
	private RemoteWebDriver webDriver;
	private FileDownloadDemo FileDownloadPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		FileDownloadPage = new FileDownloadDemo(webDriver);
		FileDownloadPage.openViaUrl(FileDownloadDemo.getUrl());
		FileDownloadPage.initializeElements(webDriver);
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
	public void enterDataAndDownloadFile() throws Exception {
		initializeSettings();
		//FileDownloadPage.enterDataFieldClick();
		FileDownloadPage.enterDataFieldInputText("test");
		Thread.sleep(1000);
		FileDownloadPage.generateFileButtonClick();
		Thread.sleep(1000);
		FileDownloadPage.downloadFileButtonClick();
	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
