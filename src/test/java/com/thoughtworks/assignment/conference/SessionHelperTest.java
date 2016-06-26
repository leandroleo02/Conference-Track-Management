package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.assignment.conference.model.BreakSession;
import com.thoughtworks.assignment.conference.model.BreakSession.BreakSessionType;
import com.thoughtworks.assignment.conference.model.Session;
import com.thoughtworks.assignment.conference.model.TalkSession;

public class SessionHelperTest {

	@Test
	public void testCreateMorningSession() {
		TalkSession expected = new TalkSession(LocalTime.of(9, 0), LocalTime.of(12, 0));
		assertThat(SessionHelper.createMorningSession(), equalTo(expected));
	}

	@Test
	public void testCreateLunchSession() {
		BreakSession expected = new BreakSession(LocalTime.of(12, 0), LocalTime.of(13, 0), BreakSessionType.LUNCH);
		assertThat(SessionHelper.createLunchSession(), equalTo(expected));
	}

	@Test
	public void testCreateAfternoonSession() {
		TalkSession expected = new TalkSession(LocalTime.of(13, 0), LocalTime.of(17, 0));
		assertThat(SessionHelper.createAfternoonSession(), equalTo(expected));
	}

	@Test
	public void testCreateNetworkingSession() {
		BreakSession expected = new BreakSession(LocalTime.of(16, 0), LocalTime.of(18, 0), BreakSessionType.NETWORKING);
		assertThat(SessionHelper.createNetworkingSession(), equalTo(expected));
	}

	@Test
	public void testGetDefaultSessions() {
		List<Session> expected = Arrays.asList(SessionHelper.createMorningSession(), SessionHelper.createLunchSession(),
				SessionHelper.createAfternoonSession(), SessionHelper.createNetworkingSession());
		List<Session> defaultSessions = SessionHelper.getDefaultSessions();
		assertThat(defaultSessions, equalTo(expected));
	}
}
