package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageLogin {
	private WebDriver driver;
	
	@FindBy(how=How.NAME,using="userName")
	private WebElement userFieldElement;
	@FindBy(how=How.NAME,using="password")
	private WebElement passwordFieldElement;
	@FindBy(how=How.NAME,using="login")
	private WebElement loginButtonElement;
	@FindBy(how=How.TAG_NAME,using="input")
	private List<WebElement> fields;
	
	//private By fields;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		//userField = By.name("userName");
		//passwordField = By.name("password");
		//loginButton = By.name("login");
		//fields = By.tagName("input");
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user,String pass) {
		userFieldElement.sendKeys(user);
		passwordFieldElement.sendKeys(pass);
		loginButtonElement.click();
		/*File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("LOGIN "+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void fields_login(String user, String pass) {
		//List<WebElement> loginFields = driver.findElements(fields);
		fields.get(1).sendKeys(user);
		fields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		//List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(fields.size());
		Assert.assertTrue(fields.size()==5);
	}
}
