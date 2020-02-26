package de.pearlbay.stockai.stockrepo.restclient;


import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Interval;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

/**
 * StockTimeSeriesRestClient
 * Retrieves stockdata json from service.
 * @author joern ross (pearlbay) 2020
 */
public interface StockTimeSeriesRestClient {
    StockTimeSeriesDataDto retrieveStockTimeSeriesData(String apiKey, String symbol,
                                                       Function function, OutputSize outputSize,
                                                       Interval interval);
}
