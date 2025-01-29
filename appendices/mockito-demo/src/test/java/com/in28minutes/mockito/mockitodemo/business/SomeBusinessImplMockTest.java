package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
		assertEquals(25, someBusinessImpl.findTheGreatestFromAllData());
	}

	@Test
	void findTheGreatestFromAllData_oneValueTest() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(15, someBusinessImpl.findTheGreatestFromAllData());
	}
	
//	TODO: logic bug
	void findGreatestFromAllData_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(Integer.MIN_VALUE, someBusinessImpl.findTheGreatestFromAllData());
	}
}