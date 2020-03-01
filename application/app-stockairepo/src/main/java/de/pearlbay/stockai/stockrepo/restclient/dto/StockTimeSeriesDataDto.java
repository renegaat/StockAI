package de.pearlbay.stockai.stockrepo.restclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * StockTimeSeriesDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockTimeSeriesDataDto {
    private MetaDataDto metaData;
    private List<TimeSeriesDto> timeSeries;
}
