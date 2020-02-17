package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import de.pearlbay.stockai.stockrepo.restclient.StockTimeSeriesRestClient;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


/**
 * StockTimeSeriesClientImpl.
 *
 * Retrieves stockdata from AlphaVantage.
 * @author joern ross (pearlbay) 2020
 */
public class StockTimeSeriesClientImpl implements StockTimeSeriesClient {

    @Autowired
    private StockTimeSeriesRestClient stockTimeSeriesRestClient;

    @Value("${alphavantage.apiKey}")
    private String apiKey;

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesData(String symbol, Function function, OutputSize outputSize) {
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesRestClient.
                retrieveStockTimeSeriesDataDto(apiKey, symbol, function, outputSize);

        return StockTimeSeriesData.builder().build();
    }
}