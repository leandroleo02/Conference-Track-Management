
package com.thoughtworks.assignment.conference.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Observable;

public abstract class Session extends Observable {

	private LocalTime start;
	private LocalTime finish;

	public Session(LocalTime start, LocalTime finish) {
		this.start = start;
		this.finish = finish;
	}

	public LocalTime getStart() {
		return start;
	}

	protected void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getFinish() {
		return finish;
	}

	public long getTotalDurationInMinutes() {
		Duration duration = Duration.between(start, finish);
		return duration.toMinutes();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finish == null) ? 0 : finish.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (finish == null) {
			if (other.finish != null)
				return false;
		} else if (!finish.equals(other.finish))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
}
