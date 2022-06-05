package com.survey.dao;

import com.survey.dto.Config;

public interface ConfigDAO {

	boolean updateConfig(Config config);
	Config findConfig();
}
