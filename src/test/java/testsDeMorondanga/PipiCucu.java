package testsDeMorondanga;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PipiCucu {
	@Test
	public void verificarMultiplicacion() {
		Assert.assertEquals(2*2, 4);
	}
	@Test
	public void verificarAlgo() {
		Assert.assertEquals("A", "A");
	}
}
