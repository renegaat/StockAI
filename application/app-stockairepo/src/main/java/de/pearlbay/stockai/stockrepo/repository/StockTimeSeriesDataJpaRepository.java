package de.pearlbay.stockai.stockrepo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * StockTimeSeriesDataJpaRepository.
 *
 * @author joern ross (pearlbay) 2020
 */
@Repository
@Transactional
public interface StockTimeSeriesDataJpaRepository extends JpaRepository<StockTimeSeriesDataJpa, Long> {
    @Query(value = "SELECT * from STOCKAIREPO.STOCKTIMESERIESDATA s"
            + " INNER JOIN STOCKAIREPO.METADATA m"
            + " ON m.MD_SYMBOL = ?1 AND s.FK_METADATA_ID = m.MD_METADATA_ID"
            + " AND s.STSD_FUNCTION = ?2", nativeQuery = true)
    StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, String function);
}