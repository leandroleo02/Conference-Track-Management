package com.thoughtworks.assignment.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.thoughtworks.assignment.conference.model.Session;
import com.thoughtworks.assignment.conference.model.Talk;
import com.thoughtworks.assignment.conference.model.TalkSession;
import com.thoughtworks.assignment.conference.model.Track;

public class ConferenceController {

	private static final String MINUTE_SUFFIX = "min";
	private static final String LIGHTNING_SUFFIX = "lightning";
	private static final int LIGHTNING_MINUTES = 5;
	private static final int MAX_TALK_DURATION = 240;

	private static final Logger logger = Logger.getLogger(ConferenceController.class);

	private List<Talk> validTalks;

	public List<Track> getTrackList(List<String> proposalsList) {
		populateValidTalks(proposalsList);
		List<Track> tracks = new ArrayList<Track>();
		int trackCounter = 1;
		List<Session> sessions = SessionHelper.getSessions();
		while (!this.validTalks.isEmpty()) {
			Track track = new Track(trackCounter++);
			tracks.add(track);

			sessions.forEach(session -> {
				track.addSession(session);
				if (session instanceof TalkSession) {
					if (!this.validTalks.isEmpty()) {
						((TalkSession) session).scheduleTalks(this.validTalks);
					}
				}
			});
		}
		return tracks;
	}

	private void populateValidTalks(List<String> proposalsList) {
		this.validTalks = new ArrayList<Talk>();
		if (proposalsList == null || proposalsList.isEmpty()) {
			return;
		}
		proposalsList.forEach(talk -> {
			Pattern pattern = Pattern.compile(String.format("([^0-9]*)(\\s){1}([0-2]?[0-9]?[0-9]{1}%s|%s)\\b", MINUTE_SUFFIX, LIGHTNING_SUFFIX));
			Matcher matcher = pattern.matcher(talk);
			if (matcher.matches()) {
				String durationStr = matcher.group(3);
				int talkDuration = extractTalkDuration(durationStr);
				if (talkDuration > 0)
					this.validTalks.add(new Talk(matcher.group(1), talkDuration));
			}
		});
	}

	private int extractTalkDuration(String durationStr) {
		int talktime = 0;
		if (durationStr.endsWith(MINUTE_SUFFIX)) {
			try {
				talktime = Integer.parseInt(durationStr.substring(0, durationStr.indexOf(MINUTE_SUFFIX)));
				if (talktime > MAX_TALK_DURATION) {
					logger.info("Talk time " + talktime + " to long");
				}
			} catch (NumberFormatException e) {
				logger.info(e);
			}
		} else if (durationStr.endsWith(LIGHTNING_SUFFIX)) {
			talktime = LIGHTNING_MINUTES;
		}
		return talktime;
	}
}
