package com.thoughtworks.assignment.conference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.thoughtworks.assignment.conference.model.Track;

/**
 * TODO: criar README.
 * TODO: rever testes.
 * TODO:  rever codigo.
 * TODO: rever hora inicio networking
 */
public class Conference {

	final static Logger logger = Logger.getLogger(Conference.class);
	
	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			logger.error("Please, inform a file path to continue the execution!");
		} else {
			new Conference().execute(args[0]);
		}
	}

	public void execute(String fileName) {
		try {
			InputFileReader reader = new InputFileReader();
			List<String> talks = reader.readFile(fileName);
			ConferenceController conferenceController = new ConferenceController();
			List<Track> trackList = conferenceController.getTrackList(talks);
			printResults(trackList);
		} catch (FileNotFoundException e) {
			logger.error("File not found!", e);
		} catch (IOException e) {
			logger.error("Error to read the file!", e);
		} catch (Exception e) {
			logger.error("Sorry! Something wrong just happened. Please try again!", e);
		}
	}
	
	private void printResults(List<Track> trackList) {
		for (Track track : trackList) {
			logger.info(track);
		}
	}
}
