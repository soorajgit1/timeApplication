package com.time.v1.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.time.v1.service.TimeService;

@RunWith(MockitoJUnitRunner.class)
public class TimeControllerTest {

	@InjectMocks
	private TimeController controller;

	@Mock
	private TimeService timeService;

	@Test
	public void testFindTimeInWords() {
		String time = "12:35";
		String timeInWords = "It's Twelwe Thirty five";
		when(timeService.findTimeInWords(time)).thenReturn(timeInWords);

		String result = controller.findTimeInWords(time);

		assertEquals(timeInWords, result);

		verify(timeService).findTimeInWords(time);
	}

}
