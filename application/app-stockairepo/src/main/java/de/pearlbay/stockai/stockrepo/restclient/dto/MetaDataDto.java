package de.pearlbay.stockai.stockrepo.restclient.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * MetaDataDto object.
 * @author joern ross (pearlbay) 2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataDto {
    private String information;
}
