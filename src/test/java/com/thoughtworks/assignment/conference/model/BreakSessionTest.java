package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.assignment.conference.SessionHelper;
import com.thoughtworks.assignment.conference.model.BreakSession.BreakSessionType;

public class BreakSessionTest {

	@Test
	public void testSessionCreated() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);

		BreakSession session = new BreakSession(start, finish, BreakSessionType.LUNCH);
		assertThat("Session start is wrong", session.getStart(), equalTo(start));
		assertThat("Session finish is wrong", session.getFinish(), equalTo(finish));
		assertThat("Session type is wrong", session.getType(), equalTo(BreakSessionType.LUNCH));
	}

	@Test
	public void testUpdateTalksObservable() {

		TalkSession afternoonSession = (TalkSession) SessionHelper.createAfternoonSession();
		BreakSession networkingSession = (BreakSession) SessionHelper.createNetworkingSession();

		afternoonSession.addObserver((BreakSession) networkingSession);

		Talk talk1 = new Talk("Any talk", 60);
		Talk talk2 = new Talk("Another talk", 120);
		Talk talk3 = new Talk("Talk3", 30);

		List<Talk> originalTalks = new ArrayList<>(Arrays.asList(talk1, talk2, talk3));

		afternoonSession.scheduleTalks(originalTalks);
		
		LocalTime expected = LocalTime.of(16, 30);

		assertThat("Networking start time wrong",networkingSession.getStart(), equalTo(expected));
	}

}
