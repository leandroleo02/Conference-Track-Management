package com.thoughtworks.assignment.conference.config;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;

public final class SessionConfigFileReader {

	private static final String SESSION_CONFIG_FILE = "/sessionConfig.propertiess";

	private static SessionConfigFileReader instance;

	private SessionConfigFileReader() {
	}

	public static SessionConfigFileReader getInstance() {
		if (instance == null) {
			instance = new SessionConfigFileReader();
		}
		return instance;
	}

	public SessionConfig getConfig() {
		try {
			return readConfigFile();
		} catch (IOException e) {
			throw new IllegalStateException("Falha ao ler arquivo de configuração.", e);
		}
	}

	private SessionConfig readConfigFile() throws IOException {
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream(SESSION_CONFIG_FILE));
		return createSessionConfig(prop);
	}

	private SessionConfig createSessionConfig(Properties prop) {
		SessionConfig config = new SessionConfig();
		config.setMorningStart(LocalTime.parse(prop.getProperty("morning.start")));
		config.setMorningEnd(LocalTime.parse(prop.getProperty("morging.end")));
		config.setLunchStart(LocalTime.parse(prop.getProperty("lunch.start")));
		config.setLunchEnd(LocalTime.parse(prop.getProperty("lunch.end")));
		config.setAfternoonStart(LocalTime.parse(prop.getProperty("afternoon.start")));
		config.setAfternoonEnd(LocalTime.parse(prop.getProperty("afternoon.end")));
		config.setNetworkingStart(LocalTime.parse(prop.getProperty("networking.start")));
		config.setNetworkingEnd(LocalTime.parse(prop.getProperty("networking.end")));
		return config;
	}
}
