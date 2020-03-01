package de.pearlbay.stockai.stockrepo.service.mapper;

import de.pearlbay.stockai.common.mapper.PriceMapper;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * StockTimeSeriesDataDtoMapper.
 *
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = {PriceMapper.class, TimeSeriesDtoMapper.class, MetaDataDtoMapper.class})
public interface StockTimeSeriesDataDtoMapper {

    StockTimeSeriesDataDtoMapper INSTANCE = Mappers.getMapper(StockTimeSeriesDataDtoMapper.class);

    StockTimeSeriesDataDto toDto(StockTimeSeriesData stockTimeSeriesData);

    StockTimeSeriesData fromDto(StockTimeSeriesDataDto stockTimeSeriesDataDto);
}
