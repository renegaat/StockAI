package de.pearlbay.stockai.stockrepo.application;

import de.pearlbay.stockai.stockrepo.application.configuration.StockConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * StockAiRepoApplication. main entry.
 * @author joern ross (pearlbay) 2020
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@ComponentScan("de.pearlbay")
@EnableJpaRepositories("de.pearlbay")
@EntityScan("de.pearlbay")
@EnableScheduling
@EnableConfigurationProperties(StockConfigurationProperties.class)
@SpringBootApplication
public class StockAiRepoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(StockAiRepoApplication.class);

    public static void main(String[] args) {
        LOG.info("StockAiRepoApplication starting");
        SpringApplication.run(StockAiRepoApplication.class, args);
    }
}
