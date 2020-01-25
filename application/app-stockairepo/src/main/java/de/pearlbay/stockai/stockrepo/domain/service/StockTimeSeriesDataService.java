package de.pearlbay.stockai.stockrepo.domain.service;

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
    StockTimeSeriesData retrieveStockTimeSeriesDataBySymbol(String symbol);
    StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData);
    StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndDate(
            String symbol, LocalDateTime begin, LocalDateTime end);
}
