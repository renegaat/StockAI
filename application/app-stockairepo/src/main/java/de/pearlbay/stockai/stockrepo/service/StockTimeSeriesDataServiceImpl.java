package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
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
        return stockTimeSeriesDataRepository.findById(id).get();
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {
        return null;
    }

    @Override
    public StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData) {
        return null;
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            String symbol, Function function, LocalDateTime begin, LocalDateTime end) {
        return null;
    }

    @Override
    public void deleteStockTimeSeriesDataById(long id) {

    }

    @Override
    public void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {

    }
}
