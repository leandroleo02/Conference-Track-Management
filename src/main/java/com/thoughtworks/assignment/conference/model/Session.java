package com.thoughtworks.assignment.conference.model;

import java.time.Duration;
import java.time.LocalTime;

/**
 * A class that represents a session in a conference. A session starts and ends
 * in a specific time. Besides, a it has a bunch of {@link Talk} that will
 * happens in this period.
 */
public abstract class Session {

	private LocalTime start;
	private LocalTime finish;

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

	public long getTotalDurationInMinutes() {
		Duration duration = Duration.between(start, finish);
		return duration.toMinutes();
	}
}
