package com.in28minutes.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {

    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public Configuration setMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Configuration setMax(int max) {
        this.max = max;
        return this;
    }
}
