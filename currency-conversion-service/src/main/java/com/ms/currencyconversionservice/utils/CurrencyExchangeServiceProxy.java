package com.ms.currencyconversionservice.utils;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Elimane on Oct, 2020, at 23:58
 */
@FeignClient(name = "currency-exchange-service", url = "localhost:8002")
public interface CurrencyExchangeServiceProxy {
}
