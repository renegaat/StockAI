package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * StockTimeSeriesDataRepository.
 *
 * @author joern ross (pearlbay) 2020
 */

@Repository
@Transactional
public class StockTimeSeriesDataRepositoryImpl implements StockTimeSeriesDataRepository {

    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataRepositoryImpl.class);

    @Autowired
    private StockTimeSeriesDataJpaRepository stockTimeSeriesDataJpaRepository;

    @Override
    public StockTimeSeriesDataJpa save(StockTimeSeriesDataJpa stockTimeSeriesDataJpa) {
        return stockTimeSeriesDataJpaRepository.saveAndFlush(stockTimeSeriesDataJpa);
    }

    @Override
    public StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, Function function) {
        return stockTimeSeriesDataJpaRepository.findBySymbolAndFunction(symbol, function.toString());
    }

    @Override
    public void deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function) {
        StockTimeSeriesDataJpa stockTimeSeriesDataJpa = stockTimeSeriesDataJpaRepository
                .findBySymbolAndFunction(symbol, function.name());

        if (stockTimeSeriesDataJpa == null) {
            LOG.warn("Record  : " + symbol + " " + function.toString() + " could not be deleted");
            return;
        }

        stockTimeSeriesDataJpaRepository.deleteById(stockTimeSeriesDataJpa.getId());
        stockTimeSeriesDataJpaRepository.flush();
    }
}
