package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *TimeSeriesJpa.
 *@author joern ross (pearlbay) 2020
 */
@Entity
@Table(name = "timeseries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TimeSeriesJpa extends BaseJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeseries_id_seq")
    @SequenceGenerator(name = "timeseries_id_seq", sequenceName = "timeseries_id_seq")
    @Column(name = "ts_timeseries_id")
    private Long id;

    @Column(name = "ts_version")
    private int version;

    @Column(name = "ts_time")
    private LocalDateTime time;
    @Column(name = "ts_open")
    private BigDecimal open;
    @Column(name = "ts_high")
    private BigDecimal high;
    @Column(name = "ts_low")
    private BigDecimal low;
    @Column(name = "ts_close")
    private BigDecimal close;
    @Column(name = "ts_volume")
    private double volume;
}