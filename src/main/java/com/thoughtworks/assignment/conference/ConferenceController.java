package com.thoughtworks.assignment.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.assignment.conference.model.Talk;
import com.thoughtworks.assignment.conference.model.TalkSession;
import com.thoughtworks.assignment.conference.model.Track;

public class ConferenceController {

	private static final String MINUTE_SUFFIX = "min";
	private static final String LIGHTNING_SUFFIX = "lightning";
	private static final int LIGHTNING_MINUTES = 5;

	private List<Talk> validTalks;

	public List<Track> getTrackList(List<String> proposalsList) {
		populateValidTalks(proposalsList);
		List<Track> tracks = new ArrayList<Track>();
		int trackCounter = 1;
		while (!this.validTalks.isEmpty()) {
			Track track = new Track(trackCounter++);
			tracks.add(track);

			SessionHelper.getDefaultSessions().forEach(session -> {
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
			Pattern pattern = Pattern.compile("(.*)(\\s){1}([0-2]?[0-9]?[0-9]{1}min|lightning)\\b");
			Matcher matcher = pattern.matcher(talk);
			if (matcher.matches()) {
				String durationStr = matcher.group(3);
				int talkDuration = extractTalkDuration(durationStr);
				this.validTalks.add(new Talk(matcher.group(1), talkDuration));
			}
		});
	}

	private int extractTalkDuration(String durationStr) {
		int talktime = 0;
		if (durationStr.endsWith(MINUTE_SUFFIX)) {
			talktime = Integer.parseInt(durationStr.substring(0, durationStr.indexOf(MINUTE_SUFFIX)));
		} else if (durationStr.endsWith(LIGHTNING_SUFFIX)) {
			talktime = LIGHTNING_MINUTES;
		}
		return talktime;
	}
}
