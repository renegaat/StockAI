package de.pearlbay.stockai.stockrepo.application.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Stock configuration properties component.
 * @author joern ross (pearlbay) 2020
 */
@Data
@ConfigurationProperties(prefix = "stock")
public class StockConfigurationProperties {
    private int refresh;
    private String market;
    private String currency;
    private List<String> symbol;
    private List<String> function;
    private List<String> outputSize;
    private List<String> interval;
}
