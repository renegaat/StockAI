package de.pearlbay.stockai.stockrepo.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTimeSeriesDataRepository extends JpaRepository<StockTimeSeriesData, Long>{
}
