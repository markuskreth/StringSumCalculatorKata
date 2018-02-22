package de.kreth.kata.stringsum;

import java.util.StringTokenizer;

public class StringCalculator {
	public static int sum(String numbers) {
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		int result = 0;
		if(numbers.contains(",")) {
			StringTokenizer tok = new StringTokenizer(numbers, ",");
			while(tok.hasMoreTokens()) {
				result += Integer.parseInt(tok.nextToken());
			}
		} else {
			result = Integer.parseInt(numbers);
		}
		
		return result;
	}
}
