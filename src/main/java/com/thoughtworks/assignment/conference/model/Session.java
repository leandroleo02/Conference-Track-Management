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

	public void schedule(List<Talk> validTalks) {
		int w = (int) Duration.between(start, finish).toMinutes();
		int n = validTalks.size();

		int[] profit = new int[n + 1];
		int[] weight = new int[n + 1];

		int i = 0;
		// fill the profit and weight
		for (Talk talk : validTalks) {
			profit[i] = weight[i] = talk.getDuration();
			i++;
		}
		
		Knapsack.knapSack(w, weight, profit, n);
	}
}
