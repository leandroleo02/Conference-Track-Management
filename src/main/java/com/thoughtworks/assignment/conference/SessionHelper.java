package com.thoughtworks.assignment.conference;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.assignment.conference.model.BreakSession;
import com.thoughtworks.assignment.conference.model.BreakSession.BreakSessionType;
import com.thoughtworks.assignment.conference.model.Session;
import com.thoughtworks.assignment.conference.model.TalkSession;

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
		return Arrays.asList(createMorningSession(), createLunchSession(), createAfternoonSession(), createNetworkingSession());
	}

	/**
	 * Represents a Morning session, 9:00AM - 12:00 noon
	 */
	public static Session createMorningSession() {
		return new TalkSession(LocalTime.of(9, 0), LocalTime.of(12, 0));
	}

	/**
	 * Represents a Lunch session, 12:00 noon - 13:00PM
	 */
	public static Session createLunchSession() {
		return new BreakSession(LocalTime.of(12, 0), LocalTime.of(13, 0), BreakSessionType.LUNCH);
	}

	/**
	 * Represents a Afternoon session - 1:00PM - 5:00PM.
	 */
	public static Session createAfternoonSession() {
		return new TalkSession(LocalTime.of(13, 0), LocalTime.of(17, 0));
	}

	/**
	 * Represents a Networking session, 4:00PM - 6:00PM
	 */
	public static Session createNetworkingSession() {
		return new BreakSession(LocalTime.of(16, 0), LocalTime.of(18, 0), BreakSessionType.NETWORKING);
	}
}
