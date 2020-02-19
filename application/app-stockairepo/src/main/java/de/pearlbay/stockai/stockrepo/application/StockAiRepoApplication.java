package de.pearlbay.stockai.stockrepo.application;

import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * StockAiRepoApplication. main entry.
 * @author joern ross (pearlbay) 2020
 */
@ComponentScan("de.pearlbay")
@EnableJpaRepositories("de.pearlbay")
@EntityScan("de.pearlbay")
@EnableScheduling
@SpringBootApplication
public class StockAiRepoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(StockAiRepoApplication.class);


    public static void main(String[] args) {
        LOG.info("StockAiRepoApplication starting");
        SpringApplication.run(StockAiRepoApplication.class, args);
    }
}
