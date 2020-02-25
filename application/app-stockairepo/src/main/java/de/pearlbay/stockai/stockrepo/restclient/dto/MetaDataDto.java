package de.pearlbay.stockai.stockrepo.restclient.dto;
import lombok.Builder;
import lombok.Data;

/**
 * MetaDataDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
public class MetaDataDto {
    private String information;
    private String symbol;
    private String lastRefreshed;
    private String timeZone;
}
