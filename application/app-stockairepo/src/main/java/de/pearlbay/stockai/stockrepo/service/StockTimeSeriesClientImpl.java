package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;


/**
 * StockTimeSeriesClientImpl.
 *
 * Retrieves stockdata from AlphaVantage.
 * @author joern ross (pearlbay) 2020
 */
public class StockTimeSeriesClientImpl implements StockTimeSeriesClient {
    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesData(String symbol, Function function, OutputSize outputSize) {
        return null;
    }
}
