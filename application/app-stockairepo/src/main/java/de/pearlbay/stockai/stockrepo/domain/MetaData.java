package de.pearlbay.stockai.stockrepo.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class MetaData {
    private String information;
    private String symbol;
    private LocalDateTime lastRefreshed;
    private ZoneId timeZone;
}
