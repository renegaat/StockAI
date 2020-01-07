package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *TimeSeriesJpa.
 *@author joern ross (pearlbay) 2020
 */
@Entity
@Table(name = "timeseries")
@Data
@EqualsAndHashCode(callSuper = true)
public class TimeSeriesJpa extends BaseJpa {
    @Id
    @GeneratedValue(generator = "timeseries_id_seq")
    @SequenceGenerator(name = "timeseries_id_seq", sequenceName = "timeseries_id_seq")
    @Column(name = "timeseries_id")
    private Long id;

    private LocalDateTime time;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private double volume;
}
    