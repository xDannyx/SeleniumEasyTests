package jUnitTest;

import java.util.concurrent.TimeUnit;
import pageObject.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadioButtonsTests {
	//nazwy zmiennych maja mowic do czego zostaly uzyte
	private RemoteWebDriver webDriver;
	private RadioButtonsDemo radioButtonsPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	//RemoteWebDriver i path do chromedrivera ma byc w pliku z testami glownymi
	//before i after mozna wydzielic do testow glownych
	//testy dla kazdej strony maja byc w oddzielnych plikach
	//ten plik ma byc tylko do testowania strony z radio buttonami
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", path);
		webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	//Tests for Radio Button Demo section
	@Test
	public void maleTest() throws Exception {
		radioButtonsPage = new RadioButtonsDemo(webDriver);
		radioButtonsPage.openViaUrl(RadioButtonsDemo.getUrl());
		radioButtonsPage.initializeElements(webDriver);
		radioButtonsPage.maleRBClick();
		radioButtonsPage.checkButtonTier1Click();
		
		Assert.assertEquals("Radio button 'Male' is checked",radioButtonsPage.getResultMessageTier1().getText());
	}
	
	@Test
	public void femaleTest() throws Exception {
		radioButtonsPage = new RadioButtonsDemo(webDriver);
		radioButtonsPage.openViaUrl(RadioButtonsDemo.getUrl());
		radioButtonsPage.initializeElements(webDriver);
		radioButtonsPage.femaleRBClick();
		radioButtonsPage.checkButtonTier1Click();
		
		Assert.assertEquals("Radio button 'Female' is checked",radioButtonsPage.getResultMessageTier1().getText());
	}
	
	//Tests for Group Radio Buttons Demo section
	
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
	
	
	
	
	
}
