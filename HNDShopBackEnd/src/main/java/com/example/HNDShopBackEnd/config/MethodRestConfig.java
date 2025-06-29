package com.example.HNDShopBackEnd.config;

import com.example.HNDShopBackEnd.entity.Product;
import com.example.HNDShopBackEnd.entity.Image;
import com.example.HNDShopBackEnd.entity.Category;
// import các entity bạn cần expose id

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

        // Expose ID cho các entity cụ thể
        config.exposeIdsFor(Product.class, Image.class, Category.class);


        cors.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
