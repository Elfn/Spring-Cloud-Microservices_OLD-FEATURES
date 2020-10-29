package com.ms.currencyexchangeservice.controller;

import com.ms.currencyexchangeservice.entities.ExchangeValue;
import com.ms.currencyexchangeservice.services.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Elimane on Oct, 2020, at 12:03
 */
@RestController
@Slf4j
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);


    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeService exchangeService;

    //http://localhost:8000/currency-exchange/from/{from}/to/{to}
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveEchangeValue(@PathVariable String from, @PathVariable String to){

        //ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65),0);

        ExchangeValue exchangeValue = exchangeService.findByFromAndTo(from,to);

//        if(exchangeValue == null) logger.debug("Data not found!");

        logger.info("{}",exchangeValue);

        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("server.port"))));

        return exchangeValue;
    }

}
