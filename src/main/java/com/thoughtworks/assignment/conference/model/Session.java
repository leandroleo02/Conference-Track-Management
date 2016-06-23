package com.thoughtworks.assignment.conference.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a session in a conference. A session starts and ends
 * in a specific time. Besides, a it has a bunch of {@link Talk} that will happens
 * in this period.
 */
public class Session {

	private LocalTime start;
	private LocalTime finish;
	private List<Talk> talks;

	public Session(LocalTime start, LocalTime finish) {
		this.start = start;
		this.finish = finish;
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getFinish() {
		return finish;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}

	public void addTalk(Talk talk) {
		if (this.talks == null) {
			this.talks = new ArrayList<Talk>();
		}
		this.talks.add(talk);
	}
}
