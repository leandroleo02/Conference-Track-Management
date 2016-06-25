package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InputFileReaderTest {

	private InputFileReader reader;
	
	@Before
	public void setUp() throws Exception {
		this.reader = new InputFileReader();
	}

	@Test
	public void testNonEmptyFile() throws IOException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource("testProposalsTalks.properties").getFile();
		
		List<String> talks = this.reader.readFile(file);
		assertThat("Talks can't be null", talks, notNullValue());
		assertThat("Talks can't be empty", talks.size(), not(0));
	}
}
