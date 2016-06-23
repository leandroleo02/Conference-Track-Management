package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SessionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSessionCreated() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);

		Session session = new Session(start, finish);
		assertThat("Session start is wrong", session.getStart(), equalTo(start));
		assertThat("Session finish is wrong", session.getFinish(), equalTo(finish));
	}

	@Test
	public void testAddTalk() {
		Talk talk = new Talk("Any talk", 20);

		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		Session session = new Session(start, finish);

		session.addTalk(talk);

		assertThat("Talks can't be null", session.getTalks(), notNullValue());
		assertThat("Talks can't be empty", session.getTalks().size(), not(0));
		assertThat(String.format("Talk added should be %s", talk), session.getTalks().get(0), equalTo(talk));
	}

	@Test
	public void testSetTalks() {

		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		Session session = new Session(start, finish);

		List<Talk> talks = createTalks();
		session.setTalks(talks);

		assertThat("Talks can't be null", session.getTalks(), notNullValue());
		assertThat("Talks can't be empty", session.getTalks().size(), not(0));
	}

	private List<Talk> createTalks() {
		Talk talk1 = new Talk("Any talk", 20);
		Talk talk2 = new Talk("Another talk", 50);

		return Arrays.asList(talk1, talk2);
	}
}
