package com.ms.app.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Elimane on Oct, 2020, at 14:33
 */
@Component
@ConfigurationProperties("limits-service")
@Data
public class Configuration {
    private int minimum;
    private int maximum;
}
