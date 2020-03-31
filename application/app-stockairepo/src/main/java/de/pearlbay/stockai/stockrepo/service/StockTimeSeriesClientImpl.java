package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Interval;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import de.pearlbay.stockai.stockrepo.restclient.StockTimeSeriesRestClient;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.service.mapper.StockTimeSeriesDataDtoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


/**
 * StockTimeSeriesClientImpl.
 * Retrieves stockdata from AlphaVantage.
 *
 * @author joern ross (pearlbay) 2020
 */

@Service
public class StockTimeSeriesClientImpl implements StockTimeSeriesClient {

    private StockTimeSeriesRestClient stockTimeSeriesRestClient;

    @Value("${alphavantage.apiKey}")
    private String apiKey;

    @Autowired
    public StockTimeSeriesClientImpl(StockTimeSeriesRestClient stockTimeSeriesRestClient) {
        this.stockTimeSeriesRestClient = stockTimeSeriesRestClient;
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesData(String symbol, Function function,
                                                           OutputSize outputSize, Interval interval) {

        Assert.notNull(symbol, "syambol must not be null");
        Assert.notNull(function, "function must not be null");
        Assert.notNull(outputSize, "outputSize must not be null");

        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesRestClient
                .retrieveStockTimeSeriesData(apiKey, symbol, function, outputSize, interval);

        StockTimeSeriesDataDtoMapper stockTimeSeriesDataDtoMapper
                = Mappers.getMapper(StockTimeSeriesDataDtoMapper.class);

        return stockTimeSeriesDataDtoMapper.fromDto(stockTimeSeriesDataDto);
    }
}
