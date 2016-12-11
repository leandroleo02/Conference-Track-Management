package com.thoughtworks.assignment.conference.config;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.time.LocalTime;

import org.junit.Test;

public class SessionConfigTest {
	
	@Test
	public void testCreateConfigInstance() {
		assertThat(SessionConfigFileReader.getInstance(), notNullValue());
	}
	
	@Test
	public void testReadFile() throws IOException {

		SessionConfig config = SessionConfigFileReader.getInstance().getConfig();
		assertThat(config, notNullValue());
	}
	
	@Test
	public void testFileData() throws IOException {

		SessionConfig config = SessionConfigFileReader.getInstance().getConfig();
		assertThat(config.getMorningStart(), equalTo(LocalTime.of(9, 00)));
		assertThat(config.getMorningEnd(), equalTo(LocalTime.of(12, 00)));
		
		assertThat(config.getLunchStart(), equalTo(LocalTime.of(12, 00)));
		assertThat(config.getLunchEnd(), equalTo(LocalTime.of(13, 00)));
		
		assertThat(config.getAfternoonStart(), equalTo(LocalTime.of(13, 00)));
		assertThat(config.getAfternoonEnd(), equalTo(LocalTime.of(17, 00)));
		
		assertThat(config.getNetworkingStart(), equalTo(LocalTime.of(16, 00)));
		assertThat(config.getNetworkingEnd(), equalTo(LocalTime.of(18, 00)));
	}
}
