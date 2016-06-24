package com.thoughtworks.assignment.conference;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.assignment.conference.model.Session;

/**
 * Class to help operations upon {@link Session}.
 */
public final class SessionHelper {

	private SessionHelper() {
	}

	/**
	 * Create the default sessions for the problem - morning, aftermoon.
	 */
	public static List<Session> getDefaultSessions() {
		return Arrays.asList(createMorningSession(), createAfternoonSession());
	}

	/**
	 * Represents a Morning session, 9:00AM - 12:00 noon
	 */
	public static Session createMorningSession() {
		return new Session(LocalTime.of(9, 0), LocalTime.of(12, 0));
	}

	/**
	 * Represents a Afternoon session - 1:00PM - 5:00PM.
	 */
	public static Session createAfternoonSession() {
		return new Session(LocalTime.of(13, 0), LocalTime.of(16, 0));
	}
}
