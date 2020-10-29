package com.ms.currencyconversionservice.utils;

import com.ms.currencyconversionservice.entities.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Elimane on Oct, 2020, at 23:58
 */
//That proxy is an intermediary system to call currency exchange MS APIs
//We are using ribbon load balancer to distribute requests from proxy to all available currency-exchange-service's instances
//We are using FEIGN to be able to remotly consume  currency-exchange-service's API's
//@FeignClient(name = "currency-exchange-service", url = "localhost:8002") To talk to only one instance
//@FeignClient(name = "currency-exchange-service") //To talk to multiple instances
@FeignClient(name = "zuul-api-gateway-server") //Make request go through zuul API
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
