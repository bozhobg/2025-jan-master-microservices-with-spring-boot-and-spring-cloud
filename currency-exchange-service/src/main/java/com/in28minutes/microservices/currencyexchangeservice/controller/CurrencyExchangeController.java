package com.in28minutes.microservices.currencyexchangeservice.controller;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

// Distributed tracing log
// 2025-01-30T11:22:00.777+02:00  INFO [currency-exchange,30f55042a28a46421733e1bece9b05f7,753649880d143e1b] 2236 --- [currency-exchange] [nio-8000-exec-1] [30f55042a28a46421733e1bece9b05f7-753649880d143e1b] c.i.m.c.c.CurrencyExchangeController     : retrieveExchangeValue called with USD to INR
        logger.info("retrieveExchangeValue called with {} to {}", from, to);

        String port = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data for: " + from + " to " + to);
        }

        return currencyExchange.setEnvironment(port);
    }
}
