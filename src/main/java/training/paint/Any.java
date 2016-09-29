package training.paint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Any {

	public static int numberOfDrops() {
		int result = new Random().nextInt(100);
		System.out.println("Drops: " + result);
		return result;
	}

	public static int dropsLessThan(int lessThan) {
		int result = new Random().nextInt(lessThan);
		System.out.println("Drops (less than " + lessThan + "): " + result);
		return result;
	}

	public static int dropsGreaterThanOrEqualTo(int greaterThanOrEqualTo) {
		int result = Math.abs(new Random().nextInt(49)) + greaterThanOrEqualTo;
		System.out.println("Drops (greater than or equal to " + greaterThanOrEqualTo + "): " + result);
		return result;
	}

	public static PaintFinish finish() {
		List<PaintFinish> finishes = Collections.unmodifiableList(Arrays.asList(PaintFinish.values()));
		PaintFinish f = finishes.get(new Random().nextInt(finishes.size()));
		System.out.println(f);
		return f;
	}

	public static PaintFinish notFinish(PaintFinish finish) {
		List<PaintFinish> finishes = Arrays.asList(PaintFinish.values());

		PaintFinish result = finish;
		while (result == finish) {
			result = finishes.get(new Random().nextInt(finishes.size()));
		}
		System.out.println("Not " + finish + ": " + result);

		return result;
	}

}
