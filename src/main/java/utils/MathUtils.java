package utils;

import java.util.Random;

public class MathUtils {

	public static int generateInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max + 1 - min) + min;
	}
}
