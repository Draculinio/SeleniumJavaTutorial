package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Login extends CondicionesComunes{
	
	
	@Test(description="Login Incorrecto")
	public void loginIncorrecto() {
		WebDriverManager.setWindowSize(driver, "maximized");
		//driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtube.com/user/Draculinio");
		//driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("user", "user");
		pageLogon.assertLogonPage();
	}
	
	@Test(description="Login con credenciales correctas",enabled=false)
	public void login() {
		WebDriverManager.setWindowSize(driver, "fullscreen");
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury", "imercury");
		pageReservation.assertPage();
	}
	
	
	
	@Test(description="Verificar la cantidad de campos que tiene el login",enabled=false)
	public void pruebaCantidadDeCampos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
	}
	
	@Test(description="Verificar título correcto en el login")
	public void pruebaTituloEnUsuario() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.putTitleInUserField();
	}
	
	
}