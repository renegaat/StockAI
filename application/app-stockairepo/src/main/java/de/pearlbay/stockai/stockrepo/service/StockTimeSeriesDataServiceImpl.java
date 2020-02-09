package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import de.pearlbay.stockai.stockrepo.repository.mapper.StockTimeSeriesDataJpaMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StockTimeSeriesDataServiceImpl.
 *
 * @author joern ross (pearlbay) 2020
 */

public class StockTimeSeriesDataServiceImpl implements StockTimeSeriesDataService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper
                = Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa =
                stockTimeSeriesDataRepository.save(stockTimeSeriesDataJpaMapper.toJpa(stockTimeSeriesData));

        if (jpa == null) {
            throw new RuntimeException("Error saving StockTimeSeriesDataJpa into DB");
        }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            String symbol, Function function, LocalDateTime start, LocalDateTime stop) {

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa = stockTimeSeriesDataRepository.findBySymbolAndFunction(symbol, function);

        if (jpa == null) {
            return null;
        }

        StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesDataJpaMapper.fromJpa(jpa);

        List<TimeSeries> timeSeriesList = stockTimeSeriesData.getTimeSeries().stream()
                .filter(timeSeries -> timeSeries.getTime().isAfter(start) && timeSeries.getTime().isBefore(stop))
                .collect(Collectors.toList());

        stockTimeSeriesData.setTimeSeries(timeSeriesList);

        return stockTimeSeriesData;
    }

    @Override
    public void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {
        stockTimeSeriesDataRepository.deleteStockTimeSeriesDataBySymbolAndFunction(symbol, function);
    }
}
