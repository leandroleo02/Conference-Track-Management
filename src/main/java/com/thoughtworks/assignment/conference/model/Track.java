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

	public List<Session> getSessions() {
		return sessions;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Session session : this.sessions) {
			sb.append(session);
			sb.append('\n');
		}
		return sb.toString();
	}
}
