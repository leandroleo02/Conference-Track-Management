package com.thoughtworks.assignment.conference.model;

import java.time.LocalTime;

public class BreakSession extends Session {

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
}
