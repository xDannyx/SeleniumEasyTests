package steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.SimpleFormDemo;

public class SimpleFormDemoSteps extends Steps {
	SimpleFormDemo SimpleFormPage;
    RemoteWebDriver webDriver;

    @Given("user is on SimpleFormDemoPage")
    public void goToRBP() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(SimpleFormDemo.getUrl());
        Thread.sleep(3000);
        SimpleFormPage = new SimpleFormDemo(webDriver);
        SimpleFormPage.initializeElements(webDriver);
    }

    @When("user writes something")
    public void writeSth() throws InterruptedException {
        SimpleFormPage.messageBoxInputText("AAAA");
        Thread.sleep(1500);
    }

    @When("user clicks Show Message button")
    public void clickGetCheckedValue() throws InterruptedException {
        SimpleFormPage.showMessageButtonClick();
        Thread.sleep(1500);
    }

    @When("user filss a and b")
    public void fillAndB() throws InterruptedException {
        SimpleFormPage.valueFieldAInput("3");
        SimpleFormPage.valueFieldBInput("5");
        Thread.sleep(1500);
    }

    @When("user clicks Get Total button")
    public void clickGetTotal() throws InterruptedException {
        SimpleFormPage.valueResultButtonClick();
        Thread.sleep(1500);
    }


    @Then("result should be same as user phrase")
    public void resultShouldBeSame(){
        org.junit.Assert.assertTrue(SimpleFormPage.getValueResultMessage().getText()=="AAAA");
        webDriver.close();
    }

    @Then("result should equals exactly same")
    public void resultShouldBeSameF(){
        org.junit.Assert.assertTrue(SimpleFormPage.getValueResultMessage().getText()=="8");
    }

    @AfterScenario
    public void shutDown(){
        webDriver.close();
        webDriver.quit();
    }
}
