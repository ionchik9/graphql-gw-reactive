package com.ion.solutions.graphql.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web-client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebClientConfig {
    private String customersClientUrl;
    private String carsClientUrl;
}
