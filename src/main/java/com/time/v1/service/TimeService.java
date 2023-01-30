package com.time.v1.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.time.v1.exception.TimeException;

@Service
public class TimeService {

	static String[] timeSetA = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelwe", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
			"Twenty", "Twenty one", "Twenty two", "Twenty three" };
	static String[] timeSetB = { "", "Ten", "Twenty", "Thirty", "Fourty", "Fifty" };

	public String findTimeInWords(String time) {
		validate(time);
		if (time.trim().equals("00:00") || time.trim().equals("24:00")) {
			return "It's Midnight";
		}
		if (time.trim().equals("12:00")) {
			return "It's Midday";
		}
		String[] times = time.trim().split(":");
		String hour = times[0];
		String minute = times[1];

		return String.format("It's %s %s", getHour(hour), getMinute(hour, minute));
	}

	private String getHour(String hour) {
		try {
			int hr = Integer.valueOf(hour);
			if (hr > 24) {
				throw new com.time.v1.exception.TimeException("Please provide a valid Hour between 0 and 24.");
			}
			if (hr == 0 || hr == 24) {
				return "Midnight";
			}
			return timeSetA[hr];
		} catch (Exception ex) {
			throw new TimeException("Please provide a valid Hour.");
		}
	}

	private String getMinute(String hour, String minute) {
		try {
			int hr = Integer.valueOf(hour);
			int min = Integer.valueOf(minute);
			if (min > 59) {
				throw new TimeException("Please provide a valid Minute between 0 and 59.");
			}
			String MidnightMsg = hr == 0 ? "Minutes" : "";
			if (min < 24) {
				return String.format("%s %s", timeSetA[min], MidnightMsg);
			}
			int firstDigit = Integer.valueOf(minute.substring(0, 1));
			int secondDigit = Integer.valueOf(minute.substring(1, 2));

			return String.format("%s %s %s", timeSetB[firstDigit], timeSetA[secondDigit], MidnightMsg);
		} catch (Exception ex) {
			throw new TimeException("Please provide a valid Minute.");
		}
	}

	private void validate(String time) {
		if (StringUtils.isBlank(time)) {
			throw new TimeException("Time cannot be Empty!");
		}
		if (!time.contains(":")) {
			throw new TimeException("Please provide a valid Time with HH:mm format.");
		}
		if (time.trim().split(":").length > 2) {
			throw new TimeException("Please provide a valid Time with HH:mm format.");
		}
	}
}
