package de.pearlbay.stockai.stockrepo.domain.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * StockTimeSeriesDataService.
 * @author joern ross (pearlbay) 2020
 */
@Service
public interface StockTimeSeriesDataService {
    StockTimeSeriesData retrieveStockTimeSeriesDataById(long id);
    StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function);
    StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData);
    StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            String symbol, Function function, LocalDateTime begin, LocalDateTime end);

    void deleteStockTimeSeriesDataById(long id );
    void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function);
}

