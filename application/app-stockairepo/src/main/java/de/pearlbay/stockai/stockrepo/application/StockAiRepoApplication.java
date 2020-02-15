package de.pearlbay.stockai.stockrepo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * StockAiRepoApplication. main entry.
 * @author joern ross (pearlbay) 2020
 */
@SpringBootApplication
public class StockAiRepoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(StockAiRepoApplication.class);

    public static void main(String[] args) {
        LOG.info("StockAiRepoApplication starting");
        SpringApplication.run(StockAiRepoApplication.class, args);
    }
}
