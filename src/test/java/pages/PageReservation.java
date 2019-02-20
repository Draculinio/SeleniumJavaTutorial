package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
	private final static String titleTextIdentifier= "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font";
	private final static String passengersDropIdentifier="passCount";
	private final static String fromDropIdentifier = "fromPort";
	private final static String toDropIdentifier = "toPort";
	private By passengersDrop;
	private By fromDrop;
	private By toDrop;
	private WebDriver driver;
	private By titleText;
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath(titleTextIdentifier);
		passengersDrop = By.name(passengersDropIdentifier);
		fromDrop = By.name(fromDropIdentifier);
		toDrop = By.name(toDropIdentifier);
	}
	public void assertPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Finder to search"));
	}
	
	public void selectPassengers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		Select selectPasajeros = new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
		
	}
	
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
}