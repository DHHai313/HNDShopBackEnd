package com.example.HNDShopBackEnd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] chanMethods = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.DELETE,
                HttpMethod.PATCH
        };
        // Vô hiệu hóa các phương thức HTTP cho tất cả các repository
        config.getExposureConfiguration()
                .forDomainType(Object.class) // Áp dụng cho tất cả các domain types
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods));
        cors.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}

