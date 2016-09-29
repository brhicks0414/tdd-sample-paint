package training.paint;

public class SaturationPaintParameterValidator implements PaintParameterValidator {

	@Override
	public void validate(int red, int yellow, int blue, int white, PaintFinish finish) {
		new SaturationValidator().validate(new int[] { red, blue, yellow });
	}

}
