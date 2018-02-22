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

	@Test
	void differentStringsProduce0() {
		assertInputProducesResult(0, "", "0,0", "0,0,0,0");
	}

	@Test
	void sinlgeNegative() {
		IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("-1");
		});
		assertEquals("negatives not allowed: -1", throwable.getMessage());
	}
	
	@Test
	void secondNegative() {
		IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("1000,-900");
		});
		assertEquals("negatives not allowed: -900", throwable.getMessage());
		throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("-1,1");
		});
		assertEquals("negatives not allowed: -1", throwable.getMessage());
		
	}
	
	@Test
	void twoNegatives() {
		IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("-1,1,-1,1");
		});

		assertEquals("negatives not allowed: -1,-1", throwable.getMessage());

		throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("-1,-2,-10,-11");
		});

		assertEquals("negatives not allowed: -1,-2,-10,-11", throwable.getMessage());
		throwable = assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.sum("-1, -2, -10, -11");
		});

		assertEquals("negatives not allowed: -1,-2,-10,-11", throwable.getMessage());
		
	}
	
	@Test
	void differentStringsProduce1() {
		assertInputProducesResult(1, "1", "1,0", "0,1", "0,0,1,0");
	}

	@Test
	void bigValuesSumm() {
		assertInputProducesResult(100, "100,0", "50,50", "25,25,25,25");
	}

	@Test
	void newLineDelimiter() {
		assertEquals(2, StringCalculator.sum("1\n1"));
		assertEquals(2, StringCalculator.sum("2\n"));
		assertEquals(2, StringCalculator.sum("2,\n"));
	}

	@Test
	void slashDelimiter() {
		assertEquals(2, StringCalculator.sum("1/1"));
	}

	@Test
	void differentDelimiter() {
		assertEquals(2, StringCalculator.sum("1;1"));
		assertEquals(2, StringCalculator.sum("1\t1"));
		assertEquals(2, StringCalculator.sum("1 1"));
		assertEquals(2, StringCalculator.sum("1|1"));
	}
	
	void assertInputProducesResult(int result, String... inputs) {
		for (String input: inputs) {
			assertEquals(result, StringCalculator.sum(input));			
		}
	}
}
