package de.pearlbay.stockai.stockrepo.repository.mapper;

import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.repository.TimeSeriesJpa;
import org.mapstruct.Mapper;


/**
 * TimeSeriesJpaMapper.
 * @author joern ross (pearlbay) 2020
 */
@Mapper
public interface TimeSeriesJpaMapper {
    TimeSeriesJpa toJpa(TimeSeries e);
    TimeSeries fromJpa (TimeSeriesJpa jpa);
}
