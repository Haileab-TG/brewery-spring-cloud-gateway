package io.htg.breweryspringcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouting {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
       return builder.routes()
               .route(r -> r
                       .path("/api/v1/beer/*/pagedInventory")
                       .uri("http://localhost:8083")
               )
                .route(r -> r
                        .path("/api/v1/beer/**", "/api/v1/beer*")
                        .uri("http://localhost:8081")
                )
               .route(r -> r
                       .path("/api/v1/customers*","/api/v1/customers/*/**")
                       .uri("http://localhost:8082")
               )


               .build();
    }
}
