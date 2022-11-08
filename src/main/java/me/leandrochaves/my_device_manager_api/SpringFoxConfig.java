package me.leandrochaves.my_device_manager_api;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.OAS_30)
          .select()
          .apis(RequestHandlerSelectors.basePackage("me.leandrochaves.my_device_manager_api.controller"))
          .build()
          .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "My Device Manager API", 
          "Manage your devices.", 
          "0.0.1", 
          "https://leandrochaves.me/my-device-manager-api/terms", 
          new Contact("My Device Manager API", "https://leandrochaves.me/my-device-manager-api", "mydevicemanager.api@leandrochaves.me"), 
          "All rights reserved", "https://leandrochaves.me/my-device-manager-api/license", Collections.emptyList());
    }
}
