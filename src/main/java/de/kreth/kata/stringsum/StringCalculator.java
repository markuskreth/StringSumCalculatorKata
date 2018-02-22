package de.kreth.kata.stringsum;

import java.util.StringTokenizer;

public class StringCalculator {
	
	StringCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	public static int sum(String numbers) {
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		int result = 0;
		if(numbers.matches("\\d+") == false) {
			StringTokenizer tok = new StringTokenizer(numbers, ",\r\n");
			while(tok.hasMoreTokens()) {
				result += Integer.parseInt(tok.nextToken());
			}
		} else {
			result = Integer.parseInt(numbers);
		}
		
		return result;
	}
}
