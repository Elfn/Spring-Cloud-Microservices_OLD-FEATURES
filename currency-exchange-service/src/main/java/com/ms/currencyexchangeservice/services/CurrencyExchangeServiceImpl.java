package com.ms.currencyexchangeservice.services;

import com.ms.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.ms.currencyexchangeservice.entities.ExchangeValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Elimane on Oct, 2020, at 19:50
 */
@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{


    private final CurrencyExchangeRepository exchangeRepository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeRepository.findByFromAndAndTo(from,to);
    }
}
