package jUnitTest;

import java.util.concurrent.TimeUnit;
import pageObject.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class jUnitTests {
	private RemoteWebDriver wd;
	private RadioButtonsDemo rbp;
	private String path="C:\\Users\\Danny\\eclipse-workspace\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", path);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void maleTest() throws Exception {
		rbp = new RadioButtonsDemo(wd);
		rbp.openViaUrl(RadioButtonsDemo.getUrl());
		rbp.initializeElements(wd);
		rbp.maleRBClick();
		rbp.checkButtonClick();
		
		Assert.assertEquals("Radio button 'Male' is checked",rbp.getResultMessage().getText());
	}
	
	@After
	public void setDown() throws Exception {
		wd.close();
		wd.quit();
	}
	
	
	
	
	
}
