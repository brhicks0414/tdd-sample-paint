package training.paint;

public class GlossWhiteValidator {

	public static final int MINIMUM_GLOSS_WHITE = 50;

	public void validate(int white, PaintFinish finish) {
		if (white < MINIMUM_GLOSS_WHITE && PaintFinish.GLOSS.equals(finish)) {
			throw new GlossWhiteException(white);
		}

	}

}
