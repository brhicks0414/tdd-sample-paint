package training.paint;

public class SaturationValidator {

	public static final int MAX_DROPS = 200;

	public static final int MAX_GREATER = 1;

	public void validate(int[] colorFactors) {
		int count = 0;
		for (int color : colorFactors) {
			if (color > MAX_DROPS) {
				count++;
			}
		}
		if (count > MAX_GREATER) {
			throw new SaturationException();
		}

	}

}
