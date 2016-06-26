package com.thoughtworks.assignment.conference;

import org.junit.Test;

public class ConferenceTest {

	@Test
	public void test() {
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource("testProposalsTalks.txt").getFile();
		
		new Conference().execute(file);
	}
}
