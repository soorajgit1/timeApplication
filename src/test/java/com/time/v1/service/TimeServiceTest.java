package com.time.v1.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.time.v1.exception.TimeException;

@RunWith(MockitoJUnitRunner.class)
public class TimeServiceTest {

	@InjectMocks
	private TimeService timeService;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void testFindTimeInWords() {
		String timeInWords = "It's Twelwe Thirty Five";

		String actual = timeService.findTimeInWords("12:35");

		assertEquals(timeInWords.trim(), actual.trim());
	}
	
	@Test
	public void testFindTimeInWordsWithMidnightTime() {
		String timeInWords = "It's Midnight Thirty Five Minutes";

		String actual = timeService.findTimeInWords("00:35");

		assertEquals(timeInWords.trim(), actual.trim());
	}

	@Test
	public void testFindTimeInWordsForMidday() {
		String timeInWords = "It's Midday";

		String actual = timeService.findTimeInWords("12:00");

		assertEquals(timeInWords.trim(), actual.trim());
	}

	@Test
	public void testFindTimeInWordsForMidnight() {
		String timeInWords = "It's Midnight";

		String actual = timeService.findTimeInWords("00:00");

		assertEquals(timeInWords.trim(), actual.trim());
	}

	@Test
	public void testFindTimeInWordsWithInvalidHour() {
		try {
			timeService.findTimeInWords("a:00");
		} catch (TimeException ex) {
			assertEquals("Please provide a valid Hour.", ex.getMessage());
		}
	}

	@Test
	public void testFindTimeInWordsWithInvalidMinute() {
		try {
			timeService.findTimeInWords("00:aa");
		} catch (TimeException ex) {
			assertEquals("Please provide a valid Minute.", ex.getMessage());
		}
	}

}
