package de.pearlbay.stockai.stockrepo.repository.mapper;


import de.pearlbay.stockai.common.mapper.PriceMapper;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * StockTimeSeriesDataJpaMapper.
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = {PriceMapper.class, TimeSeriesJpaMapper.class, MetaDataJpaMapper.class})
public interface StockTimeSeriesDataJpaMapper {

    StockTimeSeriesDataJpaMapper INSTANCE = Mappers.getMapper(StockTimeSeriesDataJpaMapper.class);


    StockTimeSeriesDataJpa toJpa(StockTimeSeriesData s);
    StockTimeSeriesData fromJpa(StockTimeSeriesDataJpa jpa);
}
