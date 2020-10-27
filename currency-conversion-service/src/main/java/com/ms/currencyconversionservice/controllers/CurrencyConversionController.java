package com.ms.currencyconversionservice.controllers;

import com.ms.currencyconversionservice.entities.CurrencyConversionBean;
import com.ms.currencyconversionservice.utils.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elimane on Oct, 2020, at 21:34
 */
//Here we are trying to communicate with others MS
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy exchangeServiceProxy;

    //RESTTEMPLATE COMMUNICATION
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {

        Map<String, String> params = new HashMap<>();

        params.put("from",from);
        params.put("to",to);

        //We are invoking Currency exchange Microservice
        ResponseEntity<CurrencyConversionBean> responseEntity =  new RestTemplate().getForEntity("http://localhost:8002/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, params);
        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }

    //FEIGN COMMUNICATION
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {

        CurrencyConversionBean response = exchangeServiceProxy.retrieveExchangeValue(from,to);

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }

}
