package com.ms.currencyexchangeservice.services;

import com.ms.currencyexchangeservice.entities.ExchangeValue;

/**
 * Created by Elimane on Oct, 2020, at 19:50
 */
public interface CurrencyExchangeService {
    public ExchangeValue findByFromAndTo(String from, String to);
}
