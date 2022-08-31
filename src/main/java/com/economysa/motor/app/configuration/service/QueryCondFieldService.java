package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.response.QueryCondFieldResponse;

public interface QueryCondFieldService {

	QueryCondFieldResponse listFieldByCondition(Long conditionId);
}
