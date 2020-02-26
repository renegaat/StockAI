package de.pearlbay.stockai.stockrepo.domain.service;


import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Interval;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import org.springframework.stereotype.Service;

/**
 * StockTimeSeriesClient.
 * <p>
 * Retrieves stockdata from AlphaVantage.
 *
 * @author joern ross (pearlbay) 2020
 */
@Service
public interface StockTimeSeriesClient {
    StockTimeSeriesData retrieveStockTimeSeriesData(String symbol, Function function,
                                                    OutputSize outputSize, Interval interval);
}
