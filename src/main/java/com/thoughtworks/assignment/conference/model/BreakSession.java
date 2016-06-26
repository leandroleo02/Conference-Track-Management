package com.thoughtworks.assignment.conference.model;

import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;

public class BreakSession extends Session implements Observer {

	public enum BreakSessionType {
		LUNCH("Lunch"), NETWORKING("Networking Event");

		private String description;

		BreakSessionType(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	private BreakSessionType type;

	public BreakSession(LocalTime start, LocalTime finish, BreakSessionType type) {
		super(start, finish);
		this.type = type;
	}

	public BreakSessionType getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("%s %s", getStart(), type.getDescription());
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof TalkSession) {
			if (type == BreakSessionType.NETWORKING) {
				// The networking can't start before 4:00PM
				LocalTime realFinishTime = ((TalkSession) o).getRealFinishTime();
				if (realFinishTime.isAfter(getStart())) {
					setStart(realFinishTime);
				}
			}
		}
	}
}
