package training.paint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test the integration of the PaintFactory and the Paint constructor.
 * 
 * @author brian
 *
 */
public class FactoryPaintIntegrationTest {

	@Test
	public void testRetrievePaintPropertiesAfterConstruction() {
		// Given: any blue, red, yellow, and white and any finish
		int blue = 50;
		int red = 10;
		int yellow = 20;
		int white = 51;
		PaintFinish finish = PaintFinish.GLOSS;

		// When: initialize a Paint object with given blue, red, yellow, and
		// white drops and given finish
		Paint p = new PaintFactory().createPaint(red, blue, yellow, white, finish);

		// Then: the given blue, red, yellow, and white drops and the given
		// finish can be retrieved
		assertEquals(blue, p.getBlue());
		assertEquals(red, p.getRed());
		assertEquals(yellow, p.getYellow());
		assertEquals(white, p.getWhite());
		assertEquals(finish, p.getFinish());
	}

	@Test
	public void testFailOnGlossWhiteValidation() {
		// Given: any blue, red, yellow, and white and any finish
		int blue = 50;
		int red = 10;
		int yellow = 20;
		int white = 49;
		PaintFinish finish = PaintFinish.GLOSS;

		// When: initialize a Paint object with given blue, red, yellow, and
		// white drops and given finish
		try {
			new PaintFactory().createPaint(red, blue, yellow, white, finish);
			fail("Gloss White Validator not invoked");
		} catch (GlossWhiteException e) {

		}
	}

	/**
	 * Given any number of white drops And red drops > 200 And blue drops > 200
	 * And yellow drops <= 200 When create paint Then an exception is thrown
	 */
	@Test
	public void failOnInvalidSaturation() {
		// Given any white, red > 200, blue > 200, and yellow <= 200
		// And any finish
		int blue = 201;
		int red = 201;
		int yellow = 200;
		int white = Any.dropsGreaterThanOrEqualTo(50);
		PaintFinish finish = Any.finish();

		// When: initialize a Paint object with given blue, red, yellow, and
		// white drops and given finish
		try {
			new PaintFactory().createPaint(red, blue, yellow, white, finish);
			fail("Saturation validator not invoked");
		} catch (SaturationException e) {

		}
	}
}
