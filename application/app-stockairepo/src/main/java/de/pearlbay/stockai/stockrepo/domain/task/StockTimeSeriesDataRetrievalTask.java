package de.pearlbay.stockai.stockrepo.domain.task;

import de.pearlbay.stockai.common.enums.*;
import de.pearlbay.stockai.stockrepo.application.configuration.StockConfigurationProperties;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
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

    @Autowired
    private StockConfigurationProperties stockConfigurationProperties;

    //todo jross set schedule to fixed time ?
    @Scheduled(fixedRateString = "${stock.refresh}")
    public void retrieveStockTimeSeriesData() {

        LOG.info("Started retrieveStockTimeSeriesData task");

        if (stockConfigurationProperties.getSymbol().size() != stockConfigurationProperties.getFunction().size()
                || (stockConfigurationProperties.getSymbol().size()
                != stockConfigurationProperties.getOutputSize().size())) {
            LOG.error("Stock Configuration Properties error");
            throw new RuntimeException("Configuration error");
        }

        for (int c = 0; c < stockConfigurationProperties.getSymbol().size(); c++) {

            //todo add a wait timer between each stack data retrieval.

            String symbol;
            Function function;
            OutputSize outputSize;
            Interval interval = null;

            try {

                symbol = stockConfigurationProperties.getSymbol().get(c);
                function = Function.valueOf(stockConfigurationProperties.getFunction().get(c));
                outputSize = OutputSize.valueOf(stockConfigurationProperties.getOutputSize().get(c));

                if ((stockConfigurationProperties.getInterval() != null)
                        && (stockConfigurationProperties.getInterval().get(c).compareTo("") != 0)) {
                    interval = Interval.valueOf(stockConfigurationProperties.getInterval().get(c));
                }

            } catch (IllegalArgumentException e) {
                LOG.error("Error building url parameters from stock configuration properties");
                throw new RuntimeException("Configuration error");
            }

            LOG.info("Downloading Stock Data. Symbol : " + symbol + " Function : "
                    + function.name() + " OutputSize : " + outputSize.name());

            StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesClient
                    .retrieveStockTimeSeriesData(symbol, function, outputSize, interval);

            if (stockTimeSeriesData == null) {
                LOG.warn("retrieveStockTimeSeriesData returned no result");
                return;
            }

            stockTimeSeriesData.setCurrency(Currency.valueOf(stockConfigurationProperties.getCurrency()));
            stockTimeSeriesData.setFunction(function);
            stockTimeSeriesData.setMarket(Market.valueOf(stockConfigurationProperties.getMarket()));
            stockTimeSeriesData.setStockName(symbol);

            //todo delete
            stockTimeSeriesDataService.createOrUpdateStockTimeSeriesData(stockTimeSeriesData);

            StockTimeSeriesData test = stockTimeSeriesDataService
                    .retrieveStockTimeSeriesDataBySymbolAndFunction("MSFT", Function.TIME_SERIES_WEEKLY);

            LOG.info("operation success");

        }
    }
}