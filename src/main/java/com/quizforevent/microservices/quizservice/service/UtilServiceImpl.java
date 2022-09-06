package com.quizforevent.microservices.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {
	@Autowired
    JdbcTemplate jdbcTemplate;
	String sqlgetEdition = "SELECT SYS_CONTEXT('USERENV', 'CURRENT_EDITION_NAME') FROM DUAL";
	
	@Autowired
	private Environment environment;

	@Override
	public String getEdition() {
		String edition=jdbcTemplate.queryForObject(sqlgetEdition,String.class);
		return edition;
	}

	@Override
	public String[] getProfile() {
		return this.environment.getActiveProfiles();
	}

}
