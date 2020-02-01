package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */
@Repository
public class StockTimeSeriesDataRepositoryImpl implements StockTimeSeriesDataRepository {
    @Autowired
    private StockTimeSeriesDataJpaRepository stockTimeSeriesDataJpaRepository;
    @Override
    public StockTimeSeriesDataJpa save(StockTimeSeriesDataJpa stockTimeSeriesDataJpa) {
        return stockTimeSeriesDataJpaRepository.save(stockTimeSeriesDataJpa);
    }
    @Query
    @Override
    public StockTimeSeriesDataJpa findBySymbolAndFunctionAndDate(String symbol, Function function,
                                                                 LocalDateTime begin, LocalDateTime end) {
        return null;
    }
    @Query
    @Override
    public StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, Function function) {
        return null;
    }
}
