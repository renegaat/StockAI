package de.pearlbay.stockai.stockrepo.restclient.dto;

import lombok.Builder;
import lombok.Data;

/**
 * StockTimeSeriesDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
public class StockTimeSeriesDataDto {
    private MetaDataDto metaDataDto;
}
