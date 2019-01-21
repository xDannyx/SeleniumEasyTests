package testSuit;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

import steps.CheckBoxDemoSteps;
import steps.RadioButtonsDemoSteps;
import steps.SimpleFormDemoSteps;

public class JbehaveTestSuite {
	private static String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
    private static Embedder embedder = new Embedder();
    private static List<String> storyPaths = Arrays
            .asList("SimpleFormPage.story");

    public static void main(String[] args) {
    	 System.setProperty("webdriver.chrome.driver",path);
        embedder.candidateSteps().add(new CheckBoxDemoSteps());
        embedder.candidateSteps().add(new RadioButtonsDemoSteps());
        embedder.candidateSteps().add(new SimpleFormDemoSteps());
        try {
        embedder.runStoriesAsPaths(storyPaths);}
        catch(Exception e) {
        	System.out.println("PODCZAS TESTU WYSTAPIL BLAD");
        	System.out.println(e.getMessage());
        }
    }
}
