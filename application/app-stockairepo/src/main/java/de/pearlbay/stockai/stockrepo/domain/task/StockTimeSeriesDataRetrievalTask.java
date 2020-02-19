package de.pearlbay.stockai.stockrepo.domain.task;

import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * StockTimeSeriesDataRetrievalTask.
 *
 * @author joern ross (pearlbay) 2020
 */
@Component
public class StockTimeSeriesDataRetrievalTask {
    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataRetrievalTask.class);

    @Autowired
    private StockTimeSeriesClient stockTimeSeriesClient;

    @Autowired
    private StockTimeSeriesDataService stockTimeSeriesDataService;


    @Scheduled(fixedRate = 5000)
    public void retrieveStockTimeSeriesData() {
        LOG.info("Started retrieveStockTimeSeriesData task");

    }
}
