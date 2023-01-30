package com.time.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time.v1.service.TimeService;

@RestController
public class TimeController {

	@Autowired
	private TimeService timeService;

	@GetMapping(value = "/time-in-words")
	public String findTimeInWords(@RequestParam("time") String time) {
		return timeService.findTimeInWords(time);
	}
}
