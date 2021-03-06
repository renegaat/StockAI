package de.pearlbay.stockai.stockrepo.domain.repository;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */

@Service
@Transactional
public interface StockTimeSeriesDataRepository {
    StockTimeSeriesDataJpa save(StockTimeSeriesDataJpa stockTimeSeriesDataJpa);
    StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, Function function);
    void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function);
}
