package de.kreth.kata.stringsum;

import java.util.StringTokenizer;

public class StringCalculator {
	
	StringCalculator() {}
	
	public static int sum(String numbers) {
		
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		
		int result = 0;
		
		if(numbers.matches("\\d+") == false) {
			StringTokenizer tok = new StringTokenizer(numbers, ",\r\n/|;\t ");
			while(tok.hasMoreTokens()) {
				int parseInt = Integer.parseInt(tok.nextToken());
				if(parseInt<0) {

					StringBuilder msg = new StringBuilder("negatives not allowed: ");
					msg.append(parseInt);
					
					while(tok.hasMoreTokens()) {
						parseInt = Integer.parseInt(tok.nextToken());
						if(parseInt<0) {
							msg.append(",").append(parseInt);
						}
					}
					
					throw new IllegalArgumentException(msg.toString());
				}
				result += parseInt;
			}
		} else {
			result = Integer.parseInt(numbers);
		}
		
		return result;
	}
}
