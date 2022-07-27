package com.economysa.motor.app.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.entity.Brand;
import com.economysa.motor.app.configuration.entity.Category;
import com.economysa.motor.app.configuration.service.BrandService;
import com.economysa.motor.app.configuration.service.CategoryService;
import com.economysa.motor.app.configuration.service.UnityService;
import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.repository.ProductRepository;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository repository;
  @Autowired private ProviderService providerService;
  @Autowired private CategoryService categoryService;
  @Autowired private BrandService brandService;
  @Autowired private UnityService unityService;
  @Autowired private EntityManager em;
	
  @Override
  public Product init(ProductDto dto) {
    Product product = new Product();
    product.setCode(dto.getCode());
    product.setName(dto.getName());
    product.setCategory(categoryService.get(dto.getCategory()));
    product.setBrand(brandService.get(dto.getBrand()));
    log.info("Provider: " + dto.getProvider());
    product.setProvider(providerService.getByCode(dto.getProvider()));

    if (dto.getChatBot() == 1) {
      product.setChatBot(true);
    } else {
      product.setChatBot(false);
    }

    if (dto.getTomaPedido() == 1) {
      product.setTomaPedido(true);
    } else {
      product.setTomaPedido(false);
    }

    product.setUnitMaster(unityService.getByCode(dto.getUnitMaster()));
    product.setUnitMasterDescription(dto.getUnitMasterDescription());
    product.setUnitMasterEquivalent(dto.getUnitMasterEquivalent());
    product.setUnitMin(unityService.getByCode(dto.getUnitMin()));
    product.setUnitMinDescription(dto.getUnitMinDescription());
    product.setUnitMinEquivalent(dto.getUnitMinEquivalent());
    product.setCreationDate(UtilCore.UtilDate.fechaActual());

    return product;
  }

  @Override
  public void saveAll(List<Product> items) {
//    items.forEach(p -> repository.save(p));
    repository.saveAll(items);
  }
  
  @Override
  public Page<Product> list(Pageable pageable) {
    return repository.findAll(pageable);
  }
  
  @Override
  public List<Product> filter(SearchRequest req) {
	  
		  
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Product> cq = cb.createQuery(Product.class);	    
	Root<Product> root = cq.from(Product.class);

	List<Predicate> predicates = new ArrayList<>();

	 if(req.getProduct() != null) {
	        
	    	if(req.getProduct().getCode()!=null && !req.getProduct().getCode().isBlank() ) {
	    		
	    	    predicates.add(cb.equal(root.get("code"), req.getProduct().getCode()));

	    	}
	    	
	    	if(req.getProduct().getName()!=null && !req.getProduct().getName().isBlank()) {

	    	    predicates.add(cb.like(cb.lower(root.get("name")),"%" + req.getProduct().getName() + "%"));

	        }
	    }
	    
	    if(req.getProvider() != null) {
	    	
	    	if((req.getProvider().getCode()!=null && !req.getProvider().getCode().isBlank() ) || 
	    			(req.getProvider().getName()!=null && !req.getProvider().getName().isBlank())) {

	    	Join<Product, Provider> join = root.join("provider");


	    	if(req.getProvider().getCode()!=null && !req.getProvider().getCode().isBlank() ) {

	    	    predicates.add(cb.equal(join.get("code"), req.getProvider().getCode()));

	    	}
	    	
	    	if(req.getProvider().getName()!=null && !req.getProvider().getName().isBlank()) {

	    	    predicates.add(cb.like(cb.lower(join.get("name")),"%" + req.getProvider().getName() + "%"));

	        }
	    
	    	}
	    
	    }
	    
	    if(req.getBrand() != null) {
	    		    	
	    	if(req.getBrand().getName()!=null && !req.getBrand().getName().isBlank()) {

		    	Join<Product, Brand> join2 = root.join("brand");

	    	    predicates.add(cb.like(cb.lower(join2.get("name")),"%" + req.getBrand().getName() + "%"));

	        }
	    
	    }
	    
	    if(req.getCategory() != null) {
	    	
	    	if(req.getCategory().getName()!=null && !req.getCategory().getName().isBlank()) {

		    	Join<Product, Category> join3 = root.join("category");

	    	    predicates.add(cb.like(cb.lower(join3.get("name")),"%" + req.getCategory().getName() + "%"));

	        }
	    
	    }
	    
    cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

    return em.createQuery(cq).getResultList();        

  }

  @Override
  public Product get(Long id) {
    Optional<Product> product = repository.listByProductId(id);
    if (!product.isPresent()) {
      log.info("No Product entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.PRODUCT_NOT_FOUND);
    }
    return product.get();
  }
  
  @Override
  public Product listByProductCode(String code) {
    Optional<Product> product = repository.listByProductCode(code);
    if (!product.isPresent()) {
      log.info("No Product entity for code [ " + code + " ]");
      throw new ResourceNotFoundException(ConstantMessage.PRODUCT_NOT_FOUND);
    }
    return product.get();
  }
  
  @Override
  public List<Product> listByProductName(String name) {
    return repository.listByProductName(name);
  }
    
  @Override
  public List<Product> listByProviderId(Long providerId) {
    return repository.findByProviderId(providerId);
  }

  @Override
  public List<Product> listByProviderCode(String providerCode) {
    return repository.findByProviderCode(providerCode);
  }

  @Override
  public List<Product> listByProviderName(String providerName) {
    return repository.findByProviderName(providerName);
  }
  
  @Override
  public List<Product> listByBrandId(Long brandId) {
    return repository.findByBrandId(brandId);
  }

  @Override
  public List<Product> listByBrandName(String brandName) {
    return repository.findByBrandName(brandName);
  }
  
  @Override
  public List<Product> listByCategoryId(Long categoryId) {
    return repository.findByCategoryId(categoryId);
  }

  @Override
  public List<Product> listByCategoryName(String categoryName) {
    return repository.findByCategoryName(categoryName);
  }
  
  
  
  
  
}
