package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;


import javax.persistence.*;
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
    @Column(name = "stocktimeseriesdata_id")
    private Long id;


    private String stockName;

    @Enumerated(EnumType.STRING)
    private Currency currency;


    @Enumerated(EnumType.STRING)
    private Market market;

    private boolean newData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id", unique = true, nullable = false, insertable = true, updatable = true)
    private MetaDataJpa metaData;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "stocktimeseriesdata_id", nullable = false)
    private List<TimeSeriesJpa> timeSeries;

    @Enumerated(EnumType.STRING)
    private Function function;

}
