package de.pearlbay.stockai.stockrepo.service.mapper;

import de.pearlbay.stockai.common.mapper.PriceMapper;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.restclient.dto.TimeSeriesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * StockTimeSeriesDtoMapper.
 *
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = PriceMapper.class)
public interface TimeSeriesDtoMapper {
    @Mapping(source = "time", target = "time", dateFormat = "yyyy-MM-dd HH:mm:ss")
    TimeSeriesDto toDto(TimeSeries timeSeries);
    @Mapping(source = "time", target = "time", dateFormat = "yyyy-MM-dd HH:mm:ss")
    TimeSeries fromDto(TimeSeriesDto timeSeriesDto);
}