package training.paint;

public class PaintFactory {

	private PaintParameterValidator[] validators;

	public PaintFactory() {
		this.validators = getValidators();
	}

	protected PaintParameterValidator[] getValidators() {
		return new PaintParameterValidator[] { new SaturationPaintParameterValidator(),
				new GlossWhitePaintParameterValidator() };
	}

	public Paint createPaint(int red, int blue, int yellow, int white, PaintFinish finish) {

		for (PaintParameterValidator validator : validators) {
			validator.validate(red, yellow, blue, white, finish);
		}

		return new Paint(red, blue, yellow, white, finish);
	}
}
