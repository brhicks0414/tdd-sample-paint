package training.paint;

public class GlossWhitePaintParameterValidator implements PaintParameterValidator {

	@Override
	public void validate(int red, int yellow, int blue, int white, PaintFinish finish) {
		new GlossWhiteValidator().validate(white, finish);
	}

}
