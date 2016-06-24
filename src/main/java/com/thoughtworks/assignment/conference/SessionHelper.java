package com.thoughtworks.assignment.conference;

import java.time.LocalTime;

import com.thoughtworks.assignment.conference.model.Session;

/**
 * Class to help operations upon {@link Session}.
 */
public final class SessionHelper {

	private SessionHelper() {
	}

	/**
	 * Represents a Morning session, 9:00AM - 12:00 noon
	 */
	public static Session createMorningSession() {
		return new Session(LocalTime.of(9, 0), LocalTime.of(12, 0));
	}

	/**
	 * Represents a Lunch session, 12:00 noon - 13:00PM
	 */
	public static Session createLunchSession() {
		return new Session(LocalTime.of(12, 0), LocalTime.of(13, 0));
	}

	/**
	 * Represents a Afternoon session - 1:00PM - 5:00PM.
	 */
	public static Session createAfternoonSession() {
		return new Session(LocalTime.of(13, 0), LocalTime.of(16, 0));
	}

	/**
	 * Represents a Networking session, 4:00PM - 6:00PM
	 */
	public static Session createNetworkingSession() {
		return new Session(LocalTime.of(16, 0), LocalTime.of(18, 0));
	}
}
