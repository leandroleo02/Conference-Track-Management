package com.thoughtworks.assignment.conference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

	public List<String> readFile(String fileName) throws FileNotFoundException,
			IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				fileName)))) {
			List<String> talks = new ArrayList<>();
			String line = null;
			while ((line = br.readLine()) != null) {
				talks.add(line);
			}
			return talks;
		}
	}
}
