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

import com.economysa.motor.app.configuration.entity.ListPrice;
import com.economysa.motor.app.configuration.entity.QueryField;
import com.economysa.motor.app.configuration.entity.QueryOperator;
import com.economysa.motor.app.configuration.service.QueryFieldService;
import com.economysa.motor.app.configuration.service.QueryOperatorService;
import com.economysa.motor.app.core.controller.dto.CustomerDto;
import com.economysa.motor.app.core.controller.request.SearchConditionRequest;
import com.economysa.motor.app.core.controller.request.SearchGroupRequest;
import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.BusinessClass;
import com.economysa.motor.app.core.entity.BusinessType;
import com.economysa.motor.app.core.entity.Customer;
import com.economysa.motor.app.core.entity.Department;
import com.economysa.motor.app.core.entity.District;
import com.economysa.motor.app.core.entity.Province;
import com.economysa.motor.app.core.entity.Warehouse;
import com.economysa.motor.app.core.repository.CustomerRepository;
import com.economysa.motor.app.core.service.CustomerService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

  @Autowired private CustomerRepository repository;
  
  @Autowired private QueryFieldService queryFieldService;
  @Autowired private QueryOperatorService queryOperatorService;
  
  @Autowired private EntityManager em;
	
  @Override
  public Customer init(CustomerDto dto) {
    Customer customer = new Customer();
    //pendiente

    return customer;
  }

  @Override
  public void saveAll(List<Customer> items) {
    repository.saveAll(items);
  }
  
  @Override
  public Page<Customer> list(Pageable pageable) {
    return repository.findAll(pageable);
  }
  
  @Override
  public List<Customer> findByConditions(SearchRequest req) {
	  
		  
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);	    
	
	Root<Customer> root = cq.from(Customer.class);
	Join<Customer, District> join1 = root.join("district");
	Join<Customer, Province> join2 = root.join("province");
	Join<Customer, Department> join3 = root.join("department");
	Join<Customer, BusinessType> join4 = root.join("businessType");
	Join<Customer, Warehouse> join5 = root.join("warehouse");
	Join<Customer, Module> join6 = root.join("module");
	Join<Customer, ListPrice> join7 = root.join("listPrice");
	Join<Customer, BusinessClass> join8 = root.join("businessClass");

	
	List<Predicate> predicatesGroups = new ArrayList<>();
	List<Predicate> predicatesConditions = null;

	QueryField field = null;
	QueryOperator operator = null;
	List<String> list = null;

	Predicate groupPredicate = null;
	Predicate finalPredicate = null;
	
	for(SearchGroupRequest group:req.getSearchRules().getGroups()) {
		
		predicatesConditions = new ArrayList<>();

		for(SearchConditionRequest condition : group.getConditions()) {
			
			field = queryFieldService.get(condition.getFieldId());
			operator = queryOperatorService.get(condition.getOperatorId());
						
			switch (field.getTabledb()) {
			
			case "customer":
		
				switch (operator.getNamedb()) {
				
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(root.get(field.getNamedb()), condition.getValue()));

					break;

				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(root.get(field.getNamedb()), condition.getValue()));

					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(root.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;
				
				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(root.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(root.get(field.getNamedb())).value(list));
		    	    
					break;

				}
				
			break;

			case "district":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join1.get(field.getNamedb()), condition.getValue()));

					break;

				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join1.get(field.getNamedb()), condition.getValue()));

					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join1.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join1.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join1.get(field.getNamedb())).value(list));
		    	    
					break;

				}
								

			break;
			
			case "province":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join2.get(field.getNamedb()), condition.getValue()));

					break;

				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join2.get(field.getNamedb()), condition.getValue()));

					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join2.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;
					
				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join2.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;
	
				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join2.get(field.getNamedb())).value(list));
		    	    
					break;

				}
				

			break;
				
			case "department":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join3.get(field.getNamedb()), condition.getValue()));
			
					break;
			
				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join3.get(field.getNamedb()), condition.getValue()));
			
					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join3.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;
		
				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join3.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join3.get(field.getNamedb())).value(list));
				    
					break;
			
				}
				
			break;
			
			case "businessType":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join4.get(field.getNamedb()), condition.getValue()));

					break;

				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join4.get(field.getNamedb()), condition.getValue()));

					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join4.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join4.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join4.get(field.getNamedb())).value(list));
		    	    
					break;

				}
				
			break;
				
			case "warehouse":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join5.get(field.getNamedb()), condition.getValue()));

					break;

				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join5.get(field.getNamedb()), condition.getValue()));

					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join5.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;
				
				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join5.get(field.getNamedb())),"%" + condition.getValue() + "%"));

					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join5.get(field.getNamedb())).value(list));
		    	    
					break;

				}
				
			break;
			
			case "module":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join6.get(field.getNamedb()), condition.getValue()));
			
					break;
			
				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join6.get(field.getNamedb()), condition.getValue()));
			
					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join6.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join6.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join6.get(field.getNamedb())).value(list));
				    
					break;
			
				}
				
			break;
			
			case "listPrice":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join7.get(field.getNamedb()), condition.getValue()));
			
					break;
			
				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join7.get(field.getNamedb()), condition.getValue()));
			
					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join7.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join7.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join7.get(field.getNamedb())).value(list));
				    
					break;
			
				}
				
			break;
			
			case "businessClass":
				
				switch (operator.getNamedb()) {
				case "EQUAL":
					
					predicatesConditions.add(cb.equal(join8.get(field.getNamedb()), condition.getValue()));
			
					break;
			
				case "NOT EQUAL":
					
					predicatesConditions.add(cb.notEqual(join8.get(field.getNamedb()), condition.getValue()));
			
					break;
							
				case "LIKE":
					
					predicatesConditions.add(cb.like(cb.lower(join8.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "NOT LIKE":
					
					predicatesConditions.add(cb.notLike(cb.lower(join8.get(field.getNamedb())),"%" + condition.getValue() + "%"));
			
					break;

				case "IN":
					
					list = new ArrayList<String>();
					
					for(String s:condition.getValue().split(",")) {
						list.add(s);
					}
					
					predicatesConditions.add(cb.in(join8.get(field.getNamedb())).value(list));
				    
					break;
			
				}
				
			break;
		}
	
	}
		
		if(group.getGroupOperator().equals("AND")) {
			
			groupPredicate  = cb.and(predicatesConditions.toArray(new Predicate[0]));

		}else {
			
			groupPredicate  = cb.or(predicatesConditions.toArray(new Predicate[0]));

		}
		
		predicatesGroups.add(groupPredicate);
		
	}
		
	
	if(req.getSearchRules().getSearchOperator().equals("AND")) {
		
		finalPredicate  = cb.and(predicatesGroups.toArray(new Predicate[0]));
		
	}else {
		
		finalPredicate  = cb.or(predicatesGroups.toArray(new Predicate[0]));

	}	

    cq.select(root).where(finalPredicate);

    return em.createQuery(cq).getResultList();       

  }

  
  
  @Override
  public Customer get(Long id) {
    Optional<Customer> customer = repository.getByCustomerId(id);
    if (!customer.isPresent()) {
      log.info("No Customer entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.CUSTOMER_NOT_FOUND);
    }
    return customer.get();
  }
  
  @Override
  public Customer getByCustomerCode(String code) {
    Optional<Customer> customer = repository.getByCustomerCode(code);
    if (!customer.isPresent()) {
      log.info("No Customer entity for code [ " + code + " ]");
      throw new ResourceNotFoundException(ConstantMessage.CUSTOMER_NOT_FOUND);
    }
    return customer.get();
  }
  
  
  
  
}
