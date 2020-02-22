package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import de.pearlbay.stockai.stockrepo.repository.mapper.StockTimeSeriesDataJpaMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StockTimeSeriesDataServiceImpl.
 *
 * @author joern ross (pearlbay) 2020
 */
@Service
public class StockTimeSeriesDataServiceImpl implements StockTimeSeriesDataService {

    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataServiceImpl.class);

    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {

        Assert.notNull(symbol, "symbol must not be null");
        Assert.notNull(function, "function must not be null");

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa = stockTimeSeriesDataRepository.findBySymbolAndFunction(symbol, function);

        if (jpa == null) {
            LOG.warn("retrieveStockTimeSeriesDataBySymbolAndFunction no result : " + symbol + " " + function.name());
            return null;
        }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public StockTimeSeriesData createOrUpdateStockTimeSeriesData(StockTimeSeriesData stockTimeSeriesData) {

        Assert.notNull(stockTimeSeriesData, "stockTimeSeriesData must not be null");

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper
                = Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa =
                stockTimeSeriesDataRepository.save(stockTimeSeriesDataJpaMapper.toJpa(stockTimeSeriesData));

        if (jpa == null) {
            LOG.error("Error saving StockTimeSeriesData to repo");
            throw new RuntimeException("Repository error");
        }

        return stockTimeSeriesDataJpaMapper.fromJpa(jpa);
    }

    @Override
    public StockTimeSeriesData retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            String symbol, Function function, LocalDateTime start, LocalDateTime stop) {

        Assert.notNull(symbol, "symbol must not be null");
        Assert.notNull(function, "function must not be null");
        Assert.notNull(start, "start must not be null");
        Assert.notNull(stop, "stop must not be null");

        StockTimeSeriesDataJpaMapper stockTimeSeriesDataJpaMapper =
                Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);

        StockTimeSeriesDataJpa jpa = stockTimeSeriesDataRepository.findBySymbolAndFunction(symbol, function);

        if (jpa == null) {
            LOG.warn("retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate no result : "
                    + symbol + " " + function.name() + " " + start.toString() + " " + stop.toString());
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
        Assert.notNull(symbol, "symbol must not be null");
        Assert.notNull(function, "function must not be null");

        stockTimeSeriesDataRepository.deleteStockTimeSeriesDataBySymbolAndFunction(symbol, function);
    }
}
