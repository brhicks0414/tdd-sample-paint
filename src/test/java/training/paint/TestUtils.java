package training.paint;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public final class TestUtils {

	public static <T extends Enum> void specifyTypes(T[] actualTypes, String... expectedFinishes) {

		String[] actualFinishes = new String[actualTypes.length];

		int i = 0;
		for (T finish : actualTypes) {
			actualFinishes[i] = finish.name();
			i++;
		}

		Arrays.sort(actualFinishes);
		Arrays.sort(expectedFinishes);

		assertArrayEquals(expectedFinishes, actualFinishes);
	}
}