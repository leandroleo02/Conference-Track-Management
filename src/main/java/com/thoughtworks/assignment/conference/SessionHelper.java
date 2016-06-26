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

	public static List<Session> getDefaultSessions() {
		return Arrays.asList(createMorningSession(), createLunchSession(), createAfternoonSession(), createNetworkingSession());
	}

	public static Session createMorningSession() {
		return new TalkSession(LocalTime.of(9, 0), LocalTime.of(12, 0));
	}

	public static Session createLunchSession() {
		return new BreakSession(LocalTime.of(12, 0), LocalTime.of(13, 0), BreakSessionType.LUNCH);
	}

	public static Session createAfternoonSession() {
		return new TalkSession(LocalTime.of(13, 0), LocalTime.of(17, 0));
	}

	public static Session createNetworkingSession() {
		return new BreakSession(LocalTime.of(16, 0), LocalTime.of(18, 0), BreakSessionType.NETWORKING);
	}
}
