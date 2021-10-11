package com.economysa.motor.configuration;

import com.economysa.motor.util.ConstantCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author QuickDev
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
              .useDefaultResponseMessages(false)
              .ignoredParameterTypes(Pageable.class, UserDetails.class)
              .select()
              .apis(RequestHandlerSelectors.basePackage(ConstantCore.SWAGGER_BASE_PACKAGE))
              .paths(PathSelectors.any())
              .build()
              .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
      return new ApiInfo(
              ConstantCore.SWAGGER_TITLE,
              ConstantCore.SWAGGER_DESCRIPTION,
              ConstantCore.SWAGGER_VERSION,
              null,
              new Contact(ConstantCore.SWAGGER_CONTACT_NAME, ConstantCore.SWAGGER_CONTACT_URL,
                  ConstantCore.SWAGGER_CONTACT_EMAIL),
              null, null, Collections.emptyList()
      );
    }
}
