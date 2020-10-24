package com.ms.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Elimane on Oct, 2020, at 14:07
 */
@Data
@ToString
@AllArgsConstructor
public class LimitConfiguration {
    private int minimum;
    private int maximum;

    protected LimitConfiguration() {

    }
}
