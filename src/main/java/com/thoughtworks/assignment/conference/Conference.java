package com.thoughtworks.assignment.conference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.thoughtworks.assignment.conference.model.Track;

/**
 * TODO: criar mensagem de erro. 
 * TODO: criar README.
 * TODO: rever testes.
 * TODO:  rever codigo.
 * TODO: rever hora inicio networking
 */
public class Conference {

	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			// TODO: mensagem nome do arquivo não informado.
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
			// TODO: mensagem arquivo não encontrado
		} catch (IOException e) {
			// TODO: falha ao ler arquivo
		} catch (Exception e) {
			// TODO: mensagem erro generico
		}
	}
	
	private void printResults(List<Track> trackList) {
		for (Track track : trackList) {
			System.out.println(track);
		}
	}
}
