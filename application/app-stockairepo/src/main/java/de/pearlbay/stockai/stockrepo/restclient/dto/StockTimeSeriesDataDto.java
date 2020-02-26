package de.pearlbay.stockai.stockrepo.restclient.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * StockTimeSeriesDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
public class StockTimeSeriesDataDto {
    private MetaDataDto metaDataDto;
    private List<TimeSeriesDto> timeSeriesDtoList;
}
