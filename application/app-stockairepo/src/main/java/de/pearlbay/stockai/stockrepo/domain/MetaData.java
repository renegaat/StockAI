package de.pearlbay.stockai.stockrepo.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class MetaData {
    private String symbol;
    private String information;
    private LocalDateTime lastRefreshed;
    private ZoneId timeZone;
}
