package training.paint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ValidateSaturationTest {

	private void validateSaturation(int red, int yellow, int blue) {
		new SaturationValidator().validate(new int[] { red, yellow, blue });
	}

	private int getMaxDrops() {
		return SaturationValidator.MAX_DROPS;
	}

	@Test
	public void validateMaximumDrops() {
		assertEquals("Maximum drops was set to something other than 200", 200, getMaxDrops());
	}

	@Test
	public void testOneColorGreaterThanMax() {
		validateSaturation(getMaxDrops(), getMaxDrops(), getMaxDrops() + 1);
	}

	@Test
	public void testTwoColorsGreaterThanMax() {
		try {
			validateSaturation(getMaxDrops() + 1, getMaxDrops(), getMaxDrops() + 1);
			fail("Exception was not thrown with two colors greater than max");
		} catch (SaturationException e) {

		}
	}

	@Test
	public void testRedYellowGreaterThanMax() {
		try {
			validateSaturation(getMaxDrops() + 1, getMaxDrops() + 1, getMaxDrops());
			fail("Exception was not thrown with both red and blue were greater than max");
		} catch (SaturationException e) {

		}
	}
}
