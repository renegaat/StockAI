package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.domain.Price;
import de.pearlbay.stockai.common.persistence.domain.BaseEntity;

import java.time.LocalDateTime;

public class TimeSeries extends BaseEntity {
    private LocalDateTime time;
    private Price open;
    private Price high;
    private Price low;
    private Price close;
    private double volume;
}
