package com.ms.currencyconversionservice.utils;

import com.ms.currencyconversionservice.entities.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Elimane on Oct, 2020, at 23:58
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8002") To talk to only one instance
@FeignClient(name = "currency-exchange-service") //To talk to multiple instances
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
