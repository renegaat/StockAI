package de.pearlbay.stockai.stockrepo.domain.repository;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;

import java.time.LocalDateTime;

/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */
public interface StockTimeSeriesDataRepository {
    StockTimeSeriesDataJpa save(StockTimeSeriesDataJpa stockTimeSeriesDataJpa);
    StockTimeSeriesDataJpa findBySymbolAndFunctionAndDate(String symbol, Function function, LocalDateTime begin,
                                                          LocalDateTime end);
    StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, Function function);
}
