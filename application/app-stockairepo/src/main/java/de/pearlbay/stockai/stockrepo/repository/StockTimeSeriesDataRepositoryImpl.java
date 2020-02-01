package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */
@Repository
public class StockTimeSeriesDataRepositoryImpl implements StockTimeSeriesDataRepository {
    @Autowired
    private StockTimeSeriesDataJpaRepository stockTimeSeriesDataJpaRepository;
}
