package com.ms.currencyexchangeservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Elimane on Oct, 2020, at 12:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    private int port;


}
