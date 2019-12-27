package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.persistence.domain.BaseEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * MetaData.
 * @author joern ross (pearlbay) 2020
 */
public class MetaData extends BaseEntity {
    private String symbol;
    private String information;
    private LocalDateTime lastRefreshed;
    private ZoneId timeZone;
}
