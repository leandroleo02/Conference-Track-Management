package com.thoughtworks.assignment.conference.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.assignment.conference.Knapsack;

/**
 * A class that represents a session in a conference. A session starts and ends
 * in a specific time. Besides, a it has a bunch of {@link Talk} that will
 * happens in this period.
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

	/***
	 * Fits the Talks in the Session using the Knapsack algorithm, and updates
	 * the given talks list.
	 *
	 * @param talks
	 */
	public void scheduleTalks(List<Talk> talks) {
		List<Talk> scheduledTalks = Knapsack.solve(this, talks);
		updateTalks(talks, scheduledTalks);
	}

	/**
	 * Update the given talks list according the taked flag, and add the talks
	 * in the session.
	 *
	 * @param talks
	 * @param scheduledTalks
	 */
	private void updateTalks(List<Talk> talks, List<Talk> scheduledTalks) {
		setTalks(scheduledTalks);
		talks.removeAll(scheduledTalks);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Talk talk : this.talks) {
			sb.append(talk);
			sb.append('\n');
		}
		return sb.toString();
	}
}
