package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Cuentas {
	
	@Test
	public void verificarSuma() {
		Assert.assertEquals(1+1, 2);
	}
	
	@Test
	public void verificarResta() {
		Assert.assertEquals(1-1, 0);
	}
	
}
