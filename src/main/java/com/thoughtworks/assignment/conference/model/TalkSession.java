package com.thoughtworks.assignment.conference.model;

import java.time.LocalTime;
import java.util.List;

import com.thoughtworks.assignment.conference.Knapsack;

public class TalkSession extends Session {

	private List<Talk> talks;

	public TalkSession(LocalTime start, LocalTime finish) {
		super(start, finish);
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}

	public LocalTime getRealFinishTime() {
		int talksDuration = this.talks.stream().mapToInt(Talk::getDuration).sum();
		return this.getStart().plusMinutes(talksDuration);
	}

	public void scheduleTalks(List<Talk> talks) {
		List<Talk> scheduledTalks = Knapsack.solve(this, talks);
		updateTalks(talks, scheduledTalks);
	}

	private void updateTalks(List<Talk> talks, List<Talk> scheduledTalks) {
		// remove these talks from the original list
		talks.removeAll(scheduledTalks);
		calculateTalkStartTime(scheduledTalks);
		setTalks(scheduledTalks);
	}

	private void calculateTalkStartTime(List<Talk> scheduledTalks) {
		for (int i = 0; i < scheduledTalks.size(); i++) {
			Talk talk = scheduledTalks.get(i);
			if (i == 0) {
				talk.setStart(getStart());
			} else {
				Talk previous = scheduledTalks.get(i - 1);
				talk.setStart(previous.getFinish());
			}
		}
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
