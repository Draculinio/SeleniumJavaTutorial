package tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Screenshooter;

public class CondicionesComunes {
	protected WebDriver driver;
	ArrayList<String> tabs;
	@BeforeMethod
	public void setUp() {
		String driverByOS="";
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").equals("Windows 10")) {
			driverByOS = "Drivers/chromedriver.exe";
		}else {
			driverByOS = "Drivers/chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", driverByOS);
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(200,200));
		//driver.manage().window().setPosition(new Point(500,500));
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		//driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		//JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		//String googleWindow =  "window.open('http://www.google.com')";
		//javaScriptExecutor.executeScript(googleWindow);
		//tabs = new ArrayList<String> (driver.getWindowHandles());
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println("El test "+ result.getMethod().getDescription()+ " resultó: "+result.getStatus());
		if(!result.isSuccess()){
			Screenshooter.takeScreenshot("Error", driver);
		}
		//driver.switchTo().window(tabs.get(1)).close();
		//driver.switchTo().window(tabs.get(0)).close();
		driver.close();
		driver.quit();
	}
}
