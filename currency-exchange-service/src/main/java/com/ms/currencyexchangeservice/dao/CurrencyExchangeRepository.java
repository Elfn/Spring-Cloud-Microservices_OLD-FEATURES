package com.ms.currencyexchangeservice.dao;

import com.ms.currencyexchangeservice.entities.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Elimane on Oct, 2020, at 19:44
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
    public ExchangeValue findByFromAndAndTo(String from, String to);
}
