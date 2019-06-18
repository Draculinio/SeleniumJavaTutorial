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
import org.testng.asserts.SoftAssert;

public class PageLogin {
	private WebDriver driver;
	
	
	@FindBy(name="userName")
	private WebElement userFieldElement;
	@FindBy(name="password")
	private WebElement passwordFieldElement;
	@FindBy(name="login")
	private WebElement loginButtonElement;
	@FindBy(tagName="input")
	private List<WebElement> fields;
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/font")
	private WebElement userNameLabel;
	
	//private By fields;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user,String pass) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(userNameLabel.getText(), "Username","El texto del label de usuario es incorrecto");
		userFieldElement.sendKeys(user);
		passwordFieldElement.sendKeys(pass);
		loginButtonElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void fields_login(String user, String pass) {
		fields.get(1).sendKeys(user);
		fields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		Assert.assertTrue(fields.size()==4);
	}
	
	public void putTitleInUserField() {
		String title = driver.getTitle();
		userFieldElement.sendKeys(driver.getTitle());
		
		//Assert.assertEquals(driver.getCurrentUrl(), expected);
		Assert.assertEquals("Welcome: Mercury Tours", title);
		
	}
}
