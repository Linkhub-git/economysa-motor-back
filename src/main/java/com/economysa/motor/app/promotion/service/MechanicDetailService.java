package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;

import java.util.List;

/**
 * Servicio que gestiona las operaciones con respecto
 * al detalle de una mecánica. Permite listar, agregar
 * items a una mecánica en particular.
 *
 * @author Jeferson
 * @version 1.0
 */
public interface MechanicDetailService {

  List<MechanicDetail> list(Long mechanicId);
  MechanicDetail add(MechanicDetailRequest request);
  List<MechanicDetail> list(List<Long> mechanicIds);
}
