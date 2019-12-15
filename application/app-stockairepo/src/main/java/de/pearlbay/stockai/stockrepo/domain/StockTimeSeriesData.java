package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.common.persistence.domain.BaseEntity;

import java.util.List;

public class StockTimeSeriesData extends BaseEntity {
    private String stockName;
    private Currency currency;
    private Market market;
    private boolean isNewData;
    private MetaData metaData;
    private List<TimeSeries> timeSeries;
    private Function function;
}       
