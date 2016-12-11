package com.thoughtworks.assignment.conference.config;

import java.time.LocalTime;

public class SessionConfig {

	private LocalTime morningStart;
	private LocalTime morningEnd;
	private LocalTime lunchStart;
	private LocalTime lunchEnd;
	private LocalTime afternoonStart;
	private LocalTime afternoonEnd;
	private LocalTime networkingStart;
	private LocalTime networkingEnd;

	public LocalTime getMorningStart() {
		return morningStart;
	}

	public void setMorningStart(LocalTime morningStart) {
		this.morningStart = morningStart;
	}

	public LocalTime getMorningEnd() {
		return morningEnd;
	}

	public void setMorningEnd(LocalTime morningEnd) {
		this.morningEnd = morningEnd;
	}

	public LocalTime getLunchStart() {
		return lunchStart;
	}

	public void setLunchStart(LocalTime lunchStart) {
		this.lunchStart = lunchStart;
	}

	public LocalTime getLunchEnd() {
		return lunchEnd;
	}

	public void setLunchEnd(LocalTime lunchEnd) {
		this.lunchEnd = lunchEnd;
	}

	public LocalTime getAfternoonStart() {
		return afternoonStart;
	}

	public void setAfternoonStart(LocalTime afternoonStart) {
		this.afternoonStart = afternoonStart;
	}

	public LocalTime getAfternoonEnd() {
		return afternoonEnd;
	}

	public void setAfternoonEnd(LocalTime afternoonEnd) {
		this.afternoonEnd = afternoonEnd;
	}

	public LocalTime getNetworkingStart() {
		return networkingStart;
	}

	public void setNetworkingStart(LocalTime networkingStart) {
		this.networkingStart = networkingStart;
	}

	public LocalTime getNetworkingEnd() {
		return networkingEnd;
	}

	public void setNetworkingEnd(LocalTime networkingEnd) {
		this.networkingEnd = networkingEnd;
	}
}
