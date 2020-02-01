package de.pearlbay.stockai.stockrepo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */

@Repository
public interface StockTimeSeriesDataJpaRepository extends JpaRepository<StockTimeSeriesDataJpa, Long> {
}
