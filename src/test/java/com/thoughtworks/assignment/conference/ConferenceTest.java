package com.thoughtworks.assignment.conference;

import org.junit.Test;

public class ConferenceTest {

	@Test
	public void test() {
		String file = getClass().getClassLoader().getResource("testProposalsTalks.txt").getFile();
		
		new Conference().execute(file);
	}
}
