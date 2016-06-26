package com.thoughtworks.assignment.conference.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

	private int id;
	private List<Session> sessions;

	public Track() {
	}

	public Track(int id) {
		this();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		StringBuilder sb = new StringBuilder("Track ").append(id).append(':').append('\n');
		if (this.sessions != null) {
			this.sessions.forEach(session -> {
				sb.append(session);
				sb.append('\n');
			});
		}
		return sb.toString();
	}
}
