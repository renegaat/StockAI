package de.pearlbay.stockai.stockrepo.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * StockTimeSeriesDataRepository.
 * @author joern ross (pearlbay) 2020
 */

@Repository
public interface StockTimeSeriesDataRepository extends JpaRepository<StockTimeSeriesData, Long> {
}
