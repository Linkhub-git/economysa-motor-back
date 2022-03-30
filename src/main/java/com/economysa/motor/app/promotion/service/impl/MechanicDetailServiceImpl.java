package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.configuration.service.BrandService;
import com.economysa.motor.app.configuration.service.CategoryService;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;
import com.economysa.motor.app.promotion.repository.MechanicDetailRepository;
import com.economysa.motor.app.promotion.service.MechanicDetailService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona las operaciones con respecto
 * al detalle de una mecánica. Permite listar, agregar
 * items a una mecánica en particular.
 *
 * @author Jeferson
 * @version 1.0
 */
@Service
@Log4j2
public class MechanicDetailServiceImpl implements MechanicDetailService {

  @Autowired private MechanicDetailRepository repository;
  @Autowired private MechanicService mechanicService;

  @Autowired private ProviderService providerService;
  @Autowired private ProductService productService;
  @Autowired private CategoryService categoryService;
  @Autowired private BrandService brandService;

  /**
   * Inicializa un objecto MechanicDetail.
   * @param request - Item a registrar
   * @return - Retorna el objeto inicializado.
   */
  private MechanicDetail init(MechanicDetailRequest request) {
    MechanicDetail detail = new MechanicDetail();
    detail.setMechanic(mechanicService.get(request.getMechanic()));
    detail.setIncluded(request.getIncluded());
    detail.setType(request.getType());
    detail.setIdentifier(request.getIdentifier());
    detail.setCode(request.getCode());
    detail.setFactor(request.getFactor());
    detail.setDescription(request.getDescription());
    return detail;
  }

  /**
   * Lista todos los items asociados a una mecánica.
   * @param mechanicId - Identificador de la mecánica
   * @return - Listado de items asociados a la mecánica.
   */
  @Override
  public List<MechanicDetail> list(Long mechanicId) {
    return repository.findAll(mechanicId);
  }

  /**
   * Agrega un nuevo item ( no repetido ) al detalle
   * de la mecánica.
   * @param request - Item a registrar
   * @return - Retorna el item ya registrado.
   */
  @Override
  public MechanicDetail add(MechanicDetailRequest request) {
    MechanicDetail detail = init(request);
    validateRequest(request);
    return repository.save(detail);
  }

  /**
   * Verifica si un item ya ha sido registrado
   * en el detalle de la mecánica.
   * @param request - Item a registrar
   * @throws BadRequestException - Lanza excepción si el
   * item ya se encuentra registrado.
   */
  private void validateRequest(MechanicDetailRequest request) {
    if (repository.findByMechanicAndTypeAndCode(request.getMechanic(),
          request.getType(), request.getIdentifier()).isPresent()) {
      log.info(ConstantMessage.ITEM_ALREADY_ADDED);
      throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
    }

    // Valida el identificador
    if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_PROVIDER)) {
      providerService.get(request.getIdentifier());
    } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_ARTICLE)) {
      productService.get(request.getIdentifier());
    } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_CATEGORY)) {

    }
  }
}
