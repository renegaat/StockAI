package de.pearlbay.stockai.stockrepo.service.mapper;

import de.pearlbay.stockai.common.mapper.PriceMapper;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.restclient.dto.TimeSeriesDto;
import org.mapstruct.Mapper;

/**
 * StockTimeSeriesDtoMapper.
 *
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = PriceMapper.class)
public interface TimeSeriesDtoMapper {
    TimeSeriesDto toDto(TimeSeries timeSeries);
    TimeSeries fromDto(TimeSeriesDto timeSeriesDto);
}