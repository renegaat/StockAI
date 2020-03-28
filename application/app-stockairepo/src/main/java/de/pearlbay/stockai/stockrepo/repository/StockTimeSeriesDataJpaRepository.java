package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.common.enums.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * StockTimeSeriesDataJpaRepository.
 * @author joern ross (pearlbay) 2020
 */
@Repository
@Transactional
public interface StockTimeSeriesDataJpaRepository extends JpaRepository<StockTimeSeriesDataJpa, Long> {
    @Query(value = "select s from stocktimeseriesdata s where s.metadata.symbol = ?1"
            + " AND s.function = ?2", nativeQuery = true)
    StockTimeSeriesDataJpa findBySymbolAndFunction(String symbol, Function function);


    @Query(value= "delete (SELECT * from STOCKAIREPO.STOCKTIMESERIESDATA s" +
            " INNER JOIN STOCKAIREPO.METADATA m" +
            " ON m.SYMBOL = ?1 AND s.METADATA_ID = m.METADATA_ID" +
            " AND s.FUNCTION = ?2)", nativeQuery = true)
    void  deleteStockTimeSeriesDataBySymbolAndFunction(String symbol, Function function);
}
