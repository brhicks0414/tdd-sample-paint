package training.paint;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class CreatePaintTest {

	@Test
	public void testRetrievePaintPropertiesAfterConstruction() {
		// Given: any blue, red, yellow, and white and any finish
		int blue = Any.numberOfDrops();
		int red = Any.numberOfDrops();
		int yellow = Any.numberOfDrops();
		int white = Any.numberOfDrops();
		PaintFinish finish = Any.finish();

		// When: initialize a Paint object with given blue, red, yellow, and
		// white drops and given finish
		Paint p = new Paint(red, blue, yellow, white, finish);

		// Then: the given blue, red, yellow, and white drops and the given
		// finish can be retrieved
		assertEquals(blue, p.getBlue());
		assertEquals(red, p.getRed());
		assertEquals(yellow, p.getYellow());
		assertEquals(white, p.getWhite());
		assertEquals(finish, p.getFinish());
	}

	@Test
	public void testSpecifyProperFinishes() {
		TestUtils.specifyTypes(PaintFinish.values(), "GLOSS", "FLAT");
	}
}
