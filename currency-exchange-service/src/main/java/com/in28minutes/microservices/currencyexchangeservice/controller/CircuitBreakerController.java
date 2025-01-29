package com.in28minutes.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.github.resilience4j.retry.Retry;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreaker.class);

    //    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse" -> method to fallback to -> Depricated
//    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @GetMapping("/sample-api")
    public String sampleApi() {
        logger.info("Sample api call received");

        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy", String.class);

        return forEntity.getBody();
    }

    @GetMapping("/rate-limiter")
    @RateLimiter(name = "default") // -> 10s => 1000x calls
    public String rateLimiter() {
        logger.info("Rate limiter api call received");

        return "rate-limiter";
    }

    @GetMapping("/bulkhead")
    @Bulkhead(name = "sample-bulkhead-api")
    public String bulkhead() {
        logger.info("Rate limiter api call received");

        return "bulkhead";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
