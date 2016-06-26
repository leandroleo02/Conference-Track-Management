package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.assignment.conference.model.Track;

public class ConferenceControllerTest {

	private ConferenceController controller;

	@Before
	public void setUp() throws Exception {
		this.controller = new ConferenceController();
	}

	@Test
	public void testWithDefaultFile() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource("testProposalsTalks.txt").getFile();

		InputFileReader reader = new InputFileReader();

		List<String> talks = reader.readFile(file);
		List<Track> trackList = controller.getTrackList(talks);
		assertThat("Tracks should have size 2", trackList.size(), equalTo(2));
	}
}
