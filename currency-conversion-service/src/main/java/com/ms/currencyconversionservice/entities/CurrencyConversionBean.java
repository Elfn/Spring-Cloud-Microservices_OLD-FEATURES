package com.ms.currencyconversionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Elimane on Oct, 2020, at 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal amount;
    private BigDecimal quantity;

    private int port;
}
