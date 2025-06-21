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
        config.exposeIdsFor(Product.class, Image.class, Category.class); // 👈 Thêm dòng này

        // Vô hiệu hóa các phương thức HTTP
//        config.getExposureConfiguration()
//                .forDomainType(Object.class)
//                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods))
//                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods));
        // Chỉ chặn HTTP methods cho Category (nếu bạn không muốn client tạo Category mới)
        config.getExposureConfiguration()
                .forDomainType(Category.class)
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(chanMethods));

        // Cấu hình CORS
        cors.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
