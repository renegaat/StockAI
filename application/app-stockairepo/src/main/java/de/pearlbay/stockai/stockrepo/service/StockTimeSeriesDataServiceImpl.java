package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * StockTimeSeriesDataServiceImpl.
 * @author joern ross (pearlbay) 2020
 */
public class StockTimeSeriesDataServiceImpl implements StockTimeSeriesDataService {
    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataById(long id) {
        return null;
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbol(String symbol) {
        return null;
    }

    @Override
    public StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData) {
        return null;
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndDate(
            String symbol, LocalDateTime begin, LocalDateTime end) {
        return null;
    }
}
