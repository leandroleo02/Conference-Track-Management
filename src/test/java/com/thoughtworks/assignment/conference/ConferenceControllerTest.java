package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
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
	public void testWithDefaultProposalsTalks() throws IOException {
		List<String> talks = readFile("testProposalsTalks.txt");
		List<Track> trackList = controller.getTrackList(talks);
		assertThat("Tracks should have size 2", trackList.size(), equalTo(2));
	}

	@Test
	public void testWithNoTalks() throws IOException {
		List<String> talks = readFile("testEmptyTalks.txt");
		List<Track> trackList = controller.getTrackList(talks);
		assertThat(trackList.size(), equalTo(0));
	}

	@Test
	public void testWithInvalidFile() throws IOException {
		List<String> talks = readFile("testInvalidFile.txt");
		List<Track> trackList = controller.getTrackList(talks);
		assertThat(trackList.size(), equalTo(0));
	}

	private List<String> readFile(String fileName) throws FileNotFoundException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource(fileName).getFile();

		InputFileReader reader = new InputFileReader();

		List<String> talks = reader.readFile(file);
		return talks;
	}
}
