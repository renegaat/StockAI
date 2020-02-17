package de.pearlbay.stockai.stockrepo.restclient.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * StockTimeSeriesDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockTimeSeriesDataDto {
    private MetaDataDto metaDataDto;
}