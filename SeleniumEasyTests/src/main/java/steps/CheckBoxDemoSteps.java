package steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.BasicCheckboxDemo;

public class CheckBoxDemoSteps extends Steps {
    BasicCheckboxDemo BasicCheckboxPage;
    RemoteWebDriver webDriver;

    @Given("user is on CheckboxPage")
    public void goToRBP() throws InterruptedException {
        BasicCheckboxPage = new BasicCheckboxDemo(webDriver);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(BasicCheckboxDemo.getUrl());
        Thread.sleep(3000);
        BasicCheckboxPage.initializeElements(webDriver);
    }

    @When("user checks checkbox")
    public void writeSth() throws InterruptedException {
        BasicCheckboxPage.singleCheckboxClick();
        Thread.sleep(1500);
    }

    @Then("message should appear")
    public void resultShouldBeSameF(){
        org.junit.Assert.assertTrue(BasicCheckboxPage.getResultMessage().getText()=="Success - Check box is checked");
    }

    @AfterScenario
    public void shutDown(){
        webDriver.close();
        webDriver.quit();
    }

}
