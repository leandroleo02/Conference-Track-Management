package com.thoughtworks.assignment.conference.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.thoughtworks.assignment.conference.SessionHelper;

public class TrackTest {

	@Test
	public void testAddGetSessons() {
		Track track = new Track();
		Session morningSession = SessionHelper.createMorningSession();
		track.addSession(morningSession);
		
		assertThat("Track sessions can't be null", track.getSessions(), notNullValue());
		assertThat("Track sessions should have size 1",track.getSessions().size(), equalTo(1));
		assertThat(track.getSessions().get(0), equalTo(morningSession));
	}
}
