package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TalkSessionTest {

	@Test
	public void testSessionCreated() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);

		TalkSession session = new TalkSession(start, finish);
		assertThat("Session start is wrong", session.getStart(), equalTo(start));
		assertThat("Session finish is wrong", session.getFinish(), equalTo(finish));
	}
	
	@Test
	public void testGetRealFinishTime() {
		
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		
		Talk talk1 = new Talk("Any talk", 60);
		talk1.setStart(start);
		Talk talk2 = new Talk("Another talk", 60);
		talk2.setStart(LocalTime.of(10, 0));
		
		List<Talk> list = new ArrayList<>(Arrays.asList(talk1, talk2));
		
		TalkSession session = new TalkSession(start, finish);
		
		session.setTalks(list);
		
		LocalTime expected = LocalTime.of(11, 0);
		
		assertThat("Session real finish time is wrong", session.getRealFinishTime(), equalTo(expected));
	}
	
	@Test
	public void testGetSetTalks() {

		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		TalkSession session = new TalkSession(start, finish);

		List<Talk> talks = createTalks();
		session.setTalks(talks);

		assertThat("Talks can't be null", session.getTalks(), notNullValue());
		assertThat("Talks can't be empty", session.getTalks().size(), not(0));
	}

	private List<Talk> createTalks() {
		Talk talk1 = new Talk("Any talk", 60);
		Talk talk2 = new Talk("Another talk", 120);

		return new ArrayList<>(Arrays.asList(talk1, talk2));
	}

	@Test
	public void testTotalDurationInMinutes() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		Session session = new TalkSession(start, finish);

		assertThat("Session total duration is wrong", session.getTotalDurationInMinutes(), equalTo(180L));
	}
	
	@Test
	public void testScheduleTalks() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		TalkSession session = new TalkSession(start, finish);

		List<Talk> originalTalkList = createTalks();
		session.scheduleTalks(originalTalkList);
		
		assertThat("Original list has to be empty", originalTalkList.size(), equalTo(0));
		assertThat("Session talks list has to have 2 items", session.getTalks().size(), equalTo(2));
	}
}
