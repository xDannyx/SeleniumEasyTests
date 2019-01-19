package pageObject;

//IMPORT JAVA.UTIL.CONCURRENT.TIMEUNIT;
//
//IMPORT ORG.JUNIT.AFTERCLASS;
//IMPORT ORG.JUNIT.BEFORECLASS;
//IMPORT ORG.OPENQA.SELENIUM.CHROME.CHROMEDRIVER;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
	private RemoteWebDriver webDriver;
	protected final static String mainUrl = "https://www.seleniumeasy.com/test/";
//	private String path="C:\\Users\\Danny\\git\\SeleniumEasyTests\\SeleniumEasyTests\\files\\chromedriver.exe";
	
	public BasePage(RemoteWebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public BasePage openViaUrl(String url) {
		webDriver.get(url);
		return this;
	}
	
//	@BeforeClass
//	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", path);
//		webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		webDriver.manage().window().maximize();
//		Thread.sleep(3000);
//	}
//	
//	@AfterClass
//	public void setDown() throws Exception {
//		Thread.sleep(3000);
//		webDriver.close();
//		webDriver.quit();
//	}
}