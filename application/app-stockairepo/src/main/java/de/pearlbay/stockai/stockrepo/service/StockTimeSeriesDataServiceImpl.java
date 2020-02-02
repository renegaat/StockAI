package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import de.pearlbay.stockai.stockrepo.repository.mapper.StockTimeSeriesDataJpaMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * StockTimeSeriesDataServiceImpl.
 *
 * @author joern ross (pearlbay) 2020
 */
public class StockTimeSeriesDataServiceImpl implements StockTimeSeriesDataService {
    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa = stockTimeSeriesDataRepository.findBySymbolAndFunction(symbol, function);

        if (jpa == null) {
            return null;
        }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData) {

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

       StockTimeSeriesDataJpa jpa =
               stockTimeSeriesDataRepository.save(stockTimeSeriesDataJpaMapper.toJpa(stockTimeSeriesData));

       if (jpa == null) {
           throw new RuntimeException("Error saving StockTimeSeriesDataJpa into DB");
       }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            String symbol, Function function, LocalDateTime begin, LocalDateTime end) {

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa = stockTimeSeriesDataRepository.findBySymbolAndFunction(symbol, function);

        //TODO filter timeseries list by date start / end.

        if (jpa == null) {
            return null;
        }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {
        stockTimeSeriesDataRepository.deleteStockTimeSeriesDataBySymbolAndFunction(symbol, function);
    }
}
