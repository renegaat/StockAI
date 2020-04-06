package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.common.domain.Price;
import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.repository.mapper.MetaDataJpaMapperImpl;
import de.pearlbay.stockai.stockrepo.repository.mapper.StockTimeSeriesDataJpaMapperImpl;
import de.pearlbay.stockai.stockrepo.repository.mapper.TimeSeriesJpaMapperImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

public class MapperTest {

    public static final int LISTSIZE = 10;

    @Test
    public void shouldMapMetaDataToJpaAndBack() {

        MetaDataJpaMapperImpl metaDataJpaMapper = new MetaDataJpaMapperImpl();

        MetaData metaData = MetaData.builder().information("Information").lastRefreshed(LocalDateTime.now())
                .symbol("Symbol").timeZone(ZoneId.systemDefault()).build();

        MetaDataJpa metaDataJpa = metaDataJpaMapper.toJpa(metaData);
        MetaData result = metaDataJpaMapper.fromJpa(metaDataJpa);

        assertEquals(metaData, result);
    }

    @Test
    public void shouldMapTimeSeriesToJpaAndBack() {

        TimeSeriesJpaMapperImpl timeSeriesJpaMapper = new TimeSeriesJpaMapperImpl();

        Price testPrice = new Price();
        testPrice.setValue(BigDecimal.ONE);

        TimeSeries timeSeries = TimeSeries.builder()
                .time(LocalDateTime.now())
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        TimeSeriesJpa timeSeriesJpa = timeSeriesJpaMapper.toJpa(timeSeries);
        TimeSeries result = timeSeriesJpaMapper.fromJpa(timeSeriesJpa);

        assertEquals(timeSeries, result);
    }

    @Test
    public void shouldMapStockTimeSeriesDataToJpaAndBack(){

        StockTimeSeriesDataJpaMapperImpl stockTimeSeriesDataJpaMapper = new StockTimeSeriesDataJpaMapperImpl();

        MetaData metaData = MetaData.builder()
                .information("Information")
                .lastRefreshed(LocalDateTime.now())
                .symbol("Symbol")
                .timeZone(ZoneId.systemDefault())
                .build();

        StockTimeSeriesData stockTimeSeriesData = StockTimeSeriesData.builder()
                .metaData(metaData)
                .newData(true)
                .timeSeries(retrieveTimeSeriesList()).stockName("Stockname")
                .currency(Currency.BRL)
                .function(Function.TIME_SERIES_DAILY)
                .market(Market.CAD)
                .build();

        StockTimeSeriesDataJpa stockTimeSeriesDataJpa = stockTimeSeriesDataJpaMapper.toJpa(stockTimeSeriesData);
        StockTimeSeriesData result = stockTimeSeriesDataJpaMapper.fromJpa(stockTimeSeriesDataJpa);

        assertEquals(stockTimeSeriesData, result);
    }


    private List retrieveTimeSeriesList() {

        List<TimeSeries> timeSeriesList = new ArrayList<>();

        Price testPrice = new Price();
        testPrice.setValue(BigDecimal.ONE);

        TimeSeries timeSeries = TimeSeries.builder()
                .time(LocalDateTime.now())
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        for (int i = 0; i < LISTSIZE; i++ ) {
            timeSeriesList.add(timeSeries);
        }

        return timeSeriesList;
    }
}
