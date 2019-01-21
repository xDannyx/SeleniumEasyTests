package steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.RadioButtonsDemo;

public class RadioButtonsDemoSteps extends Steps {
	RadioButtonsDemo RadioButtonsPage;
	RemoteWebDriver webDriver;
	
    @Given("user is on RadioButtonPage")
    public void goToRBP() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(RadioButtonsDemo.getUrl());
        Thread.sleep(3000);
        RadioButtonsPage = new RadioButtonsDemo(webDriver);
        RadioButtonsPage.initializeElements(webDriver);

    }

    @When("user checks male button")
    public void checkMale() throws InterruptedException {
        RadioButtonsPage.maleRBClick();
        Thread.sleep(1500);
    }

    @When("user checks female button")
    public void checkFemale() throws InterruptedException {
        RadioButtonsPage.femaleRBClick();
        Thread.sleep(1500);
    }

    @When("user clicks Get Checked Value button")
    public void clickGetCheckedValue() throws InterruptedException {
        RadioButtonsPage.checkButtonTier1Click();
        Thread.sleep(1500);
    }


    @Then("result for male should be correct")
    public void resultShouldBeSame(){
        System.out.print(RadioButtonsPage.getResultMessageTier1().getText());
        org.junit.Assert.assertTrue(RadioButtonsPage.getResultMessageTier1().getText()=="Radio button 'Male' is checked");

    }

    @Then("result for female should be correct")
    public void resultShouldBeSameF(){
        System.out.print(RadioButtonsPage.getResultMessageTier1().getText());
        org.junit.Assert.assertTrue(RadioButtonsPage.getResultMessageTier1().getText()=="Radio button 'Female' is checked");
    }

    @AfterScenario
    public void shutDown(){
        webDriver.close();
        webDriver.quit();
    }
}
