package com.in28minutes.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public CurrencyServiceConfiguration setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrencyServiceConfiguration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getKey() {
        return key;
    }

    public CurrencyServiceConfiguration setKey(String key) {
        this.key = key;
        return this;
    }
}
