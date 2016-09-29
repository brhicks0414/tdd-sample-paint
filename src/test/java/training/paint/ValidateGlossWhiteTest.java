package training.paint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ValidateGlossWhiteTest {

	private void validateGlossWhite(int white, PaintFinish finish) {
		new GlossWhiteValidator().validate(white, finish);
	}

	@Test
	public void validateMinimumGlossWhite() {
		assertEquals("Minimum white was set to something other than 50", 50, GlossWhiteValidator.MINIMUM_GLOSS_WHITE);
	}

	@Test
	public void testWhiteLessThanMinimumAndFinishIsGloss() {
		// Throw an exception if the finish is gloss and white is less than 50
		try {
			// When: Create paint
			validateGlossWhite(GlossWhiteValidator.MINIMUM_GLOSS_WHITE - 1, PaintFinish.GLOSS);
			fail("White was less than the minimum and the finish was GLOSS but no exception was thrown");
		} catch (GlossWhiteException e) {
			// Then: throw an exception that indicates the invalid white value
			assertEquals(GlossWhiteValidator.MINIMUM_GLOSS_WHITE - 1, e.badWhite());

		}
	}

	@Test
	public void testWhiteLessThanMinimumAndFinishIsNotGloss() {
		validateGlossWhite(Any.dropsLessThan(GlossWhiteValidator.MINIMUM_GLOSS_WHITE), Any.notFinish(PaintFinish.GLOSS));
	}

	@Test
	public void testWhiteIsMinimumOrGreaterAndFinishIsGloss() {
		validateGlossWhite(GlossWhiteValidator.MINIMUM_GLOSS_WHITE, PaintFinish.GLOSS);
	}
}
