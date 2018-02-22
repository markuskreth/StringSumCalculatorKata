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
	}
}
