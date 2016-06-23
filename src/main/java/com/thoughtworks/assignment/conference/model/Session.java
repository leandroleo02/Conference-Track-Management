package com.thoughtworks.assignment.conference.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a session in a conference. A session starts and ends
 * in a specific time. Besides, a it has a bunch of {@link Talk} that will happens
 * in this period.
 */
public class Session {

	/**
	 * Represents a Morning session, 9:00AM - 12:00 noon
	 */
	public static final Session MORNING = new Session(LocalTime.of(9, 0), LocalTime.of(12, 0));

	/**
	 * Represents a Afternoon session - 1:00PM - 4:00PM. Having a tolerance of 60 minutes.
	 */
	public static final Session AFTERNOON = new Session(LocalTime.of(13, 0), LocalTime.of(16, 0), 60);

	private LocalTime start;
	private LocalTime finish;
	private int toleranceMinutesToFinish;
	private List<Talk> talks;

	public Session(LocalTime start, LocalTime finish) {
		this.start = start;
		this.finish = finish;
	}

	public Session(LocalTime start, LocalTime finish, int toleranceMinutesToFinish) {
		this(start, finish);
		this.toleranceMinutesToFinish = toleranceMinutesToFinish;
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getFinish() {
		return finish;
	}

	public int getToleranceMinutesToFinish() {
		return toleranceMinutesToFinish;
	}

	public long getTotalDurationInMinutes() {
		Duration duration = Duration.between(start, finish);
		return duration.toMinutes();
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
