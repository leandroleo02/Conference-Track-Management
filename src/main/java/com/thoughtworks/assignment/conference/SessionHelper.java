package com.thoughtworks.assignment.conference;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.assignment.conference.config.SessionConfig;
import com.thoughtworks.assignment.conference.config.SessionConfigFileReader;
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

	public static List<Session> getSessions() {
		SessionConfig config = SessionConfigFileReader.getInstance().getConfig();

		Session morningSession = new TalkSession(config.getMorningStart(), config.getMorningEnd());
		Session lunchSession = new BreakSession(config.getLunchStart(), config.getLunchEnd(), BreakSessionType.LUNCH);
		Session networkingSession = new BreakSession(config.getNetworkingStart(), config.getNetworkingEnd(),
				BreakSessionType.NETWORKING);
		Session afternoonSession = new TalkSession(config.getAfternoonStart(), config.getAfternoonEnd());
		afternoonSession.addObserver((BreakSession) networkingSession);

		return Arrays.asList(morningSession, lunchSession, afternoonSession, networkingSession);

	}

	public static List<Session> getDefaultSessions() {
		Session morningSession = createMorningSession();
		Session lunchSession = createLunchSession();
		Session afternoonSession = createAfternoonSession();
		Session networkingSession = createNetworkingSession();

		afternoonSession.addObserver((BreakSession) networkingSession);

		return Arrays.asList(morningSession, lunchSession, afternoonSession, networkingSession);
	}

	public static Session createMorningSession() {
		return new TalkSession(LocalTime.of(9, 0), LocalTime.of(12, 00));
	}

	public static Session createLunchSession() {
		return new BreakSession(LocalTime.of(12, 00), LocalTime.of(13, 00), BreakSessionType.LUNCH);
	}

	public static Session createAfternoonSession() {
		return new TalkSession(LocalTime.of(13, 00), LocalTime.of(17, 00));
	}

	public static Session createNetworkingSession() {
		return new BreakSession(LocalTime.of(16, 0), LocalTime.of(18, 0), BreakSessionType.NETWORKING);
	}
}
