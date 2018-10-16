package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.domain.Price;

import java.time.LocalDateTime;

public class TimeSeries {
    private LocalDateTime time;
    private Price open;
    private Price high;
    private Price low;
    private Price close;
    private double volume;
}
