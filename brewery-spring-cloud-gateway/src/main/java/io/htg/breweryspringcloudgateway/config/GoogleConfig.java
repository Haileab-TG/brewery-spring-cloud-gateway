package io.htg.breweryspringcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//@Profile("Google")
//@Configuration
public class GoogleConfig {
    @Bean
    public RouteLocator googleRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder
                .routes()
                .route(r -> r
                        .path("/haileabsGoogleSearch")
                        .filters(f -> f.rewritePath("/haileabsGoogleSearch(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com")
                )
                .build();
    }
}
