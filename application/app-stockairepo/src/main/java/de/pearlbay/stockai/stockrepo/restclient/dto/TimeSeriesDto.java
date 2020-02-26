package de.pearlbay.stockai.stockrepo.restclient.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * TimeSeriesDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
public class TimeSeriesDto {
    private String time;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private double volume;
}
