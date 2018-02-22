package de.kreth.kata.stringsum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testNullAndEmpty() {
		assertEquals(0, StringCalculator.sum(null));
		assertEquals(0, StringCalculator.sum(""));
		assertEquals(0, StringCalculator.sum("0"));
	}

	@Test
	void singleNumbersBecomeIntValue() {
		assertEquals(1, StringCalculator.sum("1"));
		assertEquals(2, StringCalculator.sum("2"));
		assertEquals(31, StringCalculator.sum("31"));
	}

	@Test
	void twoDigitsCommaSeparatedSummedUp() {
		assertEquals(1, StringCalculator.sum("0,1"));
		assertEquals(5, StringCalculator.sum("2,3"));
		assertEquals(0, StringCalculator.sum("0,0"));
	}
}
