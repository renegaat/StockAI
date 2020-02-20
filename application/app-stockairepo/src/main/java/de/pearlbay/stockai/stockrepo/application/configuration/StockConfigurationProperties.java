package de.pearlbay.stockai.stockrepo.application.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Stock properties component.
 * @author joern ross (pearlbay) 2020
 */
@Component
@ConfigurationProperties(prefix = "stock")
public class StockConfigurationProperties {
}
