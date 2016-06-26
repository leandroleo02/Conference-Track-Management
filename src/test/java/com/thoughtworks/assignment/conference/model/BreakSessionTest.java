package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

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

}
