package de.pearlbay.stockai.stockrepo.restclient.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MetaDataDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaDataDto {
    private String information;
    private String symbol;
    private String lastRefreshed;
    private String timeZone;
}
