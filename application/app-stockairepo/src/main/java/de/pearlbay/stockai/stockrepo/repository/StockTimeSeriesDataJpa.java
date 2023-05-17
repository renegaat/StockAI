package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;


import jakarta.persistence.*;
import java.util.List;

/**
 * StockTimeSeriesDataJpa.
 *
 * @author joern ross (pearlbay) 2020
 */
@Entity
@Table(name = "stocktimeseriesdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class StockTimeSeriesDataJpa extends BaseJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_timeseries_data_id_seq")
    @SequenceGenerator(name = "stock_timeseries_data_id_seq", sequenceName = "stock_timeseries_data_id_seq")
    @Column(name = "stsd_stocktimeseriesdata_id")
    private Long id;

    @Column(name = "stsd_version")
    private int version;

    @Column(name = "stsd_stock_name")
    private String stockName;

    @Column(name = "stsd_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "stsd_market")
    @Enumerated(EnumType.STRING)
    private Market market;

    @Column(name = "stsd_new_data")
    private boolean newData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_metadata_id", unique = true, nullable = false, insertable = true, updatable = true)
    private MetaDataJpa metaData;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "ts_stocktimeseriesdata_id", nullable = false)
    private List<TimeSeriesJpa> timeSeries;

    @Column(name = "stsd_function")
    @Enumerated(EnumType.STRING)
    private Function function;

}
