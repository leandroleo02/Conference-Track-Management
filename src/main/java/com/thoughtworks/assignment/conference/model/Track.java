package com.thoughtworks.assignment.conference.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

	private List<Session> sessions;

	public void addSession(Session session) {
		if (this.sessions == null) {
			this.sessions = new ArrayList<>();
		}
		this.sessions.add(session);
	}
}
