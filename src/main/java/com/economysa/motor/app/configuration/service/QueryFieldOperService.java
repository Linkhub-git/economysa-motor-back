package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.response.QueryFieldOperResponse;

public interface QueryFieldOperService {

	QueryFieldOperResponse listOperatorByField(Long fieldId);
}
