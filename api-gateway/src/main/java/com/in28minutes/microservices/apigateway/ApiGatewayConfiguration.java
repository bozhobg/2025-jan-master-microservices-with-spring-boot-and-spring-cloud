package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Buildable<Route>> routeFunction
                = p -> p
                // request to /get on api gateway
                .path("/get")
                // to configure headers, path parameters etc
                .filters(f -> f
                        // adding headers and params to responses
                        .addRequestHeader("MyHeader", "MyURI")
                        .addRequestParameter("Param", "MyParam"))
                // reroute to this url (using path)
                .uri("http://httpbin.org:80");

        return builder.routes()
                .route(routeFunction)
                .route(p -> p
                        .path("/currency-exchange/**")
                        // load balance service
                        .uri("lb://currency-exchange"))
                .route(p -> p
                        .path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p
                        .path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p
                        .path("/currency-conversion-new/**")
                        .filters(f -> f
                                // regex:
                                // (?<segment>.*) -> () named group (?<group name>...)
                                .rewritePath("/currency-conversion-new/(?<segment>.*)",
                                // ${segment} -> backreference by group name
                                        "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
