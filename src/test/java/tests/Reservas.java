package tests;

import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageReservation;

public class Reservas extends CondicionesComunes{
	@Test(description="Seleccionar puerto Londres",enabled=true)
	public void pruebaTres() {
		WebDriverManager.setWindowSize(driver,400,400);
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury", "mercury");
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
		
	}
}
