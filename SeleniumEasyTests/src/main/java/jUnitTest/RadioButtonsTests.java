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
	private RemoteWebDriver webDriver;
	private RadioButtonsDemo radioButtonsPage;
	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	//RemoteWebDriver i path do chromedrivera ma byc w pliku z testami glownymi
	//before i after mozna wydzielic do testow glownych
	//testy dla kazdej strony maja byc w oddzielnych plikach
	//ten plik ma byc tylko do testowania strony z radio buttonami
	
	public void settings() {
		radioButtonsPage = new RadioButtonsDemo(webDriver);
		radioButtonsPage.openViaUrl(RadioButtonsDemo.getUrl());
		radioButtonsPage.initializeElements(webDriver);
	}
	
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
//		radioButtonsPage = new RadioButtonsDemo(webDriver);
//		radioButtonsPage.openViaUrl(RadioButtonsDemo.getUrl());
//		radioButtonsPage.initializeElements(webDriver);
		settings();
		radioButtonsPage.maleRBClick();
		radioButtonsPage.checkButtonTier1Click();
		
		Assert.assertEquals("Radio button 'Male' is checked",radioButtonsPage.getResultMessageTier1().getText());
	}
	
	@Test
	public void femaleTest() throws Exception {
		settings();
		radioButtonsPage.femaleRBClick();
		radioButtonsPage.checkButtonTier1Click();
		
		Assert.assertEquals("Radio button 'Female' is checked",radioButtonsPage.getResultMessageTier1().getText());
	}
	
    @Test
    public void nothingCheckedTest() throws Exception {
    	settings();
    	radioButtonsPage.checkButtonTier1Click();

        Assert.assertEquals("Radio button is Not checked",radioButtonsPage.getResultMessageTier1().getText());
    }
	
	//Tests for Group Radio Buttons Demo section
    @Test
    public void maleFifteenToFiftyTest() throws Exception {
    	settings();
    	radioButtonsPage.maleGroupRadioButtonClick();
    	radioButtonsPage.fifeteenToFiftyGroupRadioButtonClick();
    	radioButtonsPage.checkButtonTier2Click();

        Assert.assertEquals("Sex : Male\n" + "Age group: 15 - 50",radioButtonsPage.getResultMessageTier2().getText());
    }

    @Test
    public void femaleZeroToFive() throws Exception {
    	settings();
        radioButtonsPage.femaleGroupRadioButtonClick();
        radioButtonsPage.zeroToFiveGroupRadioButtonClick();
        radioButtonsPage.checkButtonTier2Click();

        Assert.assertEquals("Sex : Female\n" + "Age group: 0 - 5",radioButtonsPage.getResultMessageTier2().getText());
    }

    @Test
    public void nothingChckedT2() throws Exception {
    	settings();
        radioButtonsPage.checkButtonTier2Click();

        Assert.assertEquals("Sex :\n" + "Age group:",radioButtonsPage.getResultMessageTier2().getText());
    }

    @Test
    public void maleNothingCheckedT2() throws Exception {
    	settings();
        radioButtonsPage.maleGroupRadioButtonClick();
        radioButtonsPage.checkButtonTier2Click();

        Assert.assertEquals("Sex : Male\n" + "Age group:",radioButtonsPage.getResultMessageTier2().getText());
    }

    @Test
    public void nothingFiveFifteenCheckedT2() throws Exception {
    	settings();
        Thread.sleep(4000);
        radioButtonsPage.fiveToFifeteenGroupRadioButtonClick();
        Thread.sleep(4000);
        radioButtonsPage.checkButtonTier2Click();
        Thread.sleep(4000);
        Assert.assertEquals("Sex :\n" + "Age group: 5 - 15",radioButtonsPage.getResultMessageTier2().getText());
    }
	
	@After
	public void setDown() throws Exception {
		Thread.sleep(3000);
		webDriver.close();
		webDriver.quit();
	}
	
}
