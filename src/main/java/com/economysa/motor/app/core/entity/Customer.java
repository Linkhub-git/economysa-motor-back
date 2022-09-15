package com.economysa.motor.app.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.economysa.motor.app.configuration.entity.ListPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcore_customer")
public class Customer {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(name = "_code")
	  @NotNull
	  @Size(min = 1, max = 10)
	  private String code;

	  @Column(name = "trade_name")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String tradeName;
	  
	  @Column(name = "business_name")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String businessName;
	  
	  @JoinColumn(name = "person_type_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private PersonType personType;
	  
	  @Column(name = "address")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String address;
	  
	  @JoinColumn(name = "district_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private District district;
	  
	  @JoinColumn(name = "province_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Province province;
	  
	  @JoinColumn(name = "department_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Department department;
	  
	  @JoinColumn(name = "country_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Country country;
	  
	  @JoinColumn(name = "address_type_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private AddressType addressType;
	  
	  @Column(name = "delivery_address")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String deliveryAddress;
	  
	  @JoinColumn(name = "delivery_district_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private District deliveryDistrict;
	  
	  @JoinColumn(name = "delivery_province_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Province deliveryProvince;
	  
	  @JoinColumn(name = "delivery_department_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Department deliveryDepartment;
	  
	  @JoinColumn(name = "delivery_country_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Country deliveryCountry;
	  
	  @Column(name = "contact_name")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String contactName;
	  
	  @Column(name = "contact_email")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String contactEmail;
	  
	  @Column(name = "contact_phone")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String contactPhone;
	  
	  @Column(name = "contact_mobile")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String contactMobile;
	  
	  @JoinColumn(name = "business_type_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private BusinessType businessType;
	  
	  @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Warehouse warehouse;
	  
	  @JoinColumn(name = "module_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Module module;
	  
	  @JoinColumn(name = "list_price_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private ListPrice listPrice;
	  
	  @JoinColumn(name = "distributor_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Distributor distributor;
	  
	  @JoinColumn(name = "business_class_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private BusinessClass businessClass;
  
  }
