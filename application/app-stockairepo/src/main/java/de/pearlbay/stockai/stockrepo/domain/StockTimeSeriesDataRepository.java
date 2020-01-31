package de.pearlbay.stockai.stockrepo.domain;


import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */

@Repository
public interface StockTimeSeriesDataRepository extends JpaRepository<StockTimeSeriesDataJpa, Long> {
    //TODO move to repository rename to StockTimeSeriesDataJpaRepository
}
