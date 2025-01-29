package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath math = new MyMath();

	@Test
	void calculateSum_ThreeArrayMembers() {
		assertEquals(6, math.calculateSum(new int[] {1, 2, 3}));
		
//		Absence of failure is success
//		Test Condition or Assert
	}
	
	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
		
//		Absence of failure is success
//		Test Condition or Assert
	}
	
//	@Test
//	void test2() {
//		int[] numbers = {};
//		int actual = math.calculateSum(numbers);
//		int expected = 0;
//		assertEquals(expected, actual);
//	}

}
