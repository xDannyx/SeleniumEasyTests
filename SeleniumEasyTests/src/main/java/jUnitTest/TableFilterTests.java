package jUnitTest;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.*;
public class TableFilterTests {
	private RemoteWebDriver webDriver;
	private TableFilterDemo TableFilterPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public void initializeSettings() {
		TableFilterPage = new TableFilterDemo(webDriver);
		TableFilterPage.openViaUrl(TableFilterDemo.getUrl());
		TableFilterPage.initializeElements(webDriver);
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
	public void filterGreenThenAllElements() throws Exception {
		initializeSettings();
		TableFilterPage.greenButtonClick();
		Thread.sleep(1000);
		TableFilterPage.allColoursButtonClick();
	}
	
	@Test
	public void filterRedThenAllElements() throws Exception {
		initializeSettings();
		TableFilterPage.redButtonClick();
		Thread.sleep(1000);
		TableFilterPage.allColoursButtonClick();
	}
	
	@Test
	public void filterOrangeThenAllElements() throws Exception {
		initializeSettings();
		TableFilterPage.orangeButtonClick();
		Thread.sleep(1000);
		TableFilterPage.allColoursButtonClick();
	}
	
//	@Test
//	public void filterAllThenAllElements() throws Exception {
//		initializeSettings();
//		TableFilterPage.allColoursButtonClick();
//	}
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
}
