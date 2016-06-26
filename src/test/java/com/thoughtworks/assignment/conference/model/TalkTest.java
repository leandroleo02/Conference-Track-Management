package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;

import org.junit.Test;

public class TalkTest {

	@Test
	public void testGetTitle() {
		Talk talk = new Talk("Talk1", 20);
		assertThat("Talk title is wrong", talk.getTitle(), equalTo("Talk1"));
	}
	
	@Test
	public void testGetDuration() {
		Talk talk = new Talk("Talk2", 10);
		assertThat("Talk duration is wrong", talk.getDuration(), equalTo(10));
	}
	
	@Test
	public void testGetSetStart() {
		Talk talk = new Talk("Talk3", 30);
		LocalTime start = LocalTime.now();
		talk.setStart(start);
		assertThat("Talk start is wrong", talk.getStart(), equalTo(start));
	}
	
	@Test
	public void testGetFinisth() {
		Talk talk = new Talk("Talk4", 50);
		LocalTime start = LocalTime.now();
		talk.setStart(start);
		
		LocalTime expected = start.plusMinutes(50);
		assertThat("Talk finish is wrong", talk.getFinish(), equalTo(expected));
	}
}
