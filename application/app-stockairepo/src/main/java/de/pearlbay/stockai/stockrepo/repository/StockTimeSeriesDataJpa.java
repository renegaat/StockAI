package de.pearlbay.stockai.stockrepo.repository;

import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 *StockTimeSeriesDataJpa.
 *@author joern ross (pearlbay) 2020 
 */
@Entity
@Table(name = "stocktimeseriesdata")
@Data
@EqualsAndHashCode(callSuper = true)
public class StockTimeSeriesDataJpa extends BaseJpa {

    @Id
    @GeneratedValue(generator = "stock_timeseries_data_id_seq")
    @SequenceGenerator(name = "stock_timeseries_data_id_seq", sequenceName = "stock_timeseries_data_id_seq")
    @Column(name = "stocktimeseriesdata_id")
    private Long id;


}
