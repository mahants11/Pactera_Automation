package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import libraries.Global;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @Description Abstract class for the driver object. this class is extended by all classes which requires driver object
 */

public class AbstractTestDriver {

	protected static  WebDriver driver;
	private static String _TestSuiteName="Pactera.com";
	public static String BROWSER 		= "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		seletcBrowser();
		System.out.println("********************************* Executing Test Suite : " + _TestSuiteName + "  *********************************");
		System.out.println("");
	}

	
	/**
	 * @Description this is a setup method for test method. this method is called before executing each test method
	 * @param 		method :- java reflection method object to get the method name
	 * @throws 		Exception
	 */


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("********************************* End of Test Suite : " + _TestSuiteName + "  *********************************");
	}

	/**
	 * @Description this is a setup method for test method. this method is called before executing each test method
	 */

	@Before
	public void setUp() throws Exception {

		// Initialize browser 
		driver = initializeDriver();
	}

	/**
	 * @Description this is a tear-down method for test method. this method is called after executing each test method
	 */

	@After
	public void tearDown() throws Exception {
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("");

		try {
			driver.quit();
		} catch (Throwable e) {
		}
	}

	/**
	 * @Description Method to initialize the driver instance
	 * @return 		WebDriver :- instance of the WebDriver
	 * @throws 		Exception
	 */

	private WebDriver initializeDriver() throws Exception {

		WebDriver driver;
		DesiredCapabilities capabilities;

		// Initialize webdriver instance
		if ("FIREFOX".equals(BROWSER)) {
			driver = new FirefoxDriver();
		} else if ("IE".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver", Global.PROJECT_ROOT + "/BrowserDriverServers/IEDriverServer32Bit.exe");
			driver = new InternetExplorerDriver();
		} else if ("IE_32_BIT".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver", Global.PROJECT_ROOT + "/BrowserDriverServers/IEDriverServer32Bit.exe");
			driver = new InternetExplorerDriver();
		} else if ("IE_64_BIT".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver", Global.PROJECT_ROOT + "/BrowserDriverServers/IEDriverServer64Bit.exe");
			driver = new InternetExplorerDriver();
		} else if ("CHROME".equals(BROWSER)) {
			System.setProperty("webdriver.chrome.driver", Global.PROJECT_ROOT + "/BrowserDriverServers/chromeDriver.exe");
			driver = new ChromeDriver();
		} else if ("SAFARI".equals(BROWSER)) {
			capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("webdriver.safari.noinstall", true);
			driver = new SafariDriver(capabilities);
		} else if ("PHANTOM_JS".equals(BROWSER)) {
			capabilities = DesiredCapabilities.phantomjs();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Global.PROJECT_ROOT + "/BrowserDriverServers/phantomjs.exe");
			driver = new PhantomJSDriver(capabilities);
		} else {

			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(Global.MAX_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	private static void seletcBrowser() {
		System.out.println("Please select approrite browser which is installed on your machine:(IE/FIREFOX/CHROME)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         
        try {
        	BROWSER = reader.readLine();
                	
        	if(BROWSER.equals("IE"))
        	{
        		System.out.println("Executing Test Cases in IE");	
        	}
        	else if(BROWSER.equals("FIREFOX"))
        	{
        		System.out.println("Executing Test Cases in FIREFOX");	
        	}
        	else if(BROWSER.equals("CHROME"))
        	{
        		System.out.println("Executing Test Cases in CHROME");	
        	}
        	else
        	{
        		System.out.println("Executing Test Cases in default browser:FireFox");
        	}
        	
        } catch (IOException e) {
            e.printStackTrace();
        } 
     
	}

}





