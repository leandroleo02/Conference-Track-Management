package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TalkTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTalkCreated() {
		Talk talk = new Talk("Talk1", 10);
		assertThat("Talk title is wrong", talk.getTitle(), equalTo("Talk1"));
		assertThat("Talk duration is wrong", talk.getDuration(), equalTo(10));
	}
}
