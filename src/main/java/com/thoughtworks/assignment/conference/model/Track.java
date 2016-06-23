package com.thoughtworks.assignment.conference.model;

import java.time.LocalTime;


public class Track {

	private static final Session MORNING = new Session(LocalTime.of(9, 0), LocalTime.of(12, 0));
	private static final Session AFTERNOON = new Session(LocalTime.of(13, 0), LocalTime.of(17, 0));

	public void configureMorningSession() {
		MORNING.addTalk(null);
		// TODO:
	}

	public void configureAfternoonSession() {
		AFTERNOON.addTalk(null);
		// TODO:
	}
}
