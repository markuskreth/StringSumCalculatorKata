package de.kreth.kata.stringsum;

public class StringCalculator {
	public static int sum(String numbers) {
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		int result = Integer.parseInt(numbers);
		
		return result;
	}
}
