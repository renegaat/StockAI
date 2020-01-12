package de.pearlbay.stockai.stockrepo.repository.mapper;


import de.pearlbay.stockai.common.mapper.PriceMapper;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * StockTimeSeriesDataJpaMapper.
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses= {PriceMapper.class, TimeSeriesJpaMapper.class, MetaDataJpaMapper.class})
public interface StockTimeSeriesDataJpaMapper {
    StockTimeSeriesDataJpa toJpa(StockTimeSeriesData s);
    StockTimeSeriesData fromJpa(StockTimeSeriesDataJpa jpa);
}
