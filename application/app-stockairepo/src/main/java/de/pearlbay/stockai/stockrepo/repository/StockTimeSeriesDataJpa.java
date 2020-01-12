package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 *StockTimeSeriesDataJpa.
 *@author joern ross (pearlbay) 2020
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
    @GeneratedValue(generator = "stock_timeseries_data_id_seq")
    @SequenceGenerator(name = "stock_timeseries_data_id_seq", sequenceName = "stock_timeseries_data_id_seq")
    @Column(name = "stocktimeseriesdata_id")
    private Long id;

    private String stockName;
    private Currency currency;
    private Market market;
    private boolean newData;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "metadata_id")
    private MetaDataJpa metaData;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stocktimeseriesdata_id")
    private List<TimeSeriesJpa> timeSeries;

    private Function function;

}
