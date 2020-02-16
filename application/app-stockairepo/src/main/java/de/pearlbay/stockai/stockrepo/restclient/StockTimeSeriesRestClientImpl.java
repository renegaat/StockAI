package de.pearlbay.stockai.stockrepo.restclient;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.springframework.stereotype.Component;

/**
 * StockTimeSeriesRestClient
 * Retrieves stockdata json from service.
 *
 * @author joern ross (pearlbay) 2020
 */
@Component
public class StockTimeSeriesRestClientImpl implements StockTimeSeriesRestClient {

    @Override
    public StockTimeSeriesDataDto retrieveStockTimeSeriesDataDto(String apiKey, String symbol,
                                                                 Function function, OutputSize outputSize) {
        return null;
    }
}
