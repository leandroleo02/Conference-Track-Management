package com.thoughtworks.assignment.conference.model;

import java.util.List;

public class Conference {

	private List<Talk> proposals;

	public Conference(List<Talk> proposals) {
		this.proposals = proposals;
	}

	public void createTracks() {
		System.out.println("creating tracks");
	}

	public List<Talk> getProposals() {
		return proposals;
	}
}
