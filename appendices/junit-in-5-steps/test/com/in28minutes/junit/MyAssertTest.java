package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
	
	@Test
	void test() {
		boolean test = todos.contains("AWS");
		boolean falseTest = todos.contains("GCP");
		assertEquals(true, test);
		assertEquals(todos.size(), 3);
		assertTrue(test);
//		assertTrue(falseTest, "GCP not contained");
		
		assertArrayEquals(new int[] {1,2,3}, new int[] {1,2,3});
		assertArrayEquals(new int[] {1,2,3}, new int[] {2});
//		fail("Not yet implemented");
	}

}
