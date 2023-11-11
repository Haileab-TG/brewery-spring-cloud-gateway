package io.htg.breweryspringcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@Configuration
public class LoadBalancedDiscoveryRouting {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r
                        .path("/api/v1/beer/*/pagedInventory")
                        .uri("lb://beer-inventory-service")
                )
                .route(r -> r
                        .path("/api/v1/beer/**", "/api/v1/beer*")
                        .uri("lb://beer-service")
                )
                .route(r -> r
                        .path("/api/v1/customers*","/api/v1/customers/*/**")
                        .uri("lb://beer-order-service")
                )
                .build();
    }
}
