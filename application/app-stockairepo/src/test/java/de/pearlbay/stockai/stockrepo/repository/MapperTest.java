package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.common.domain.Price;
import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.repository.mapper.MetaDataJpaMapperImpl;
import de.pearlbay.stockai.stockrepo.repository.mapper.TimeSeriesJpaMapperImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

public class MapperTest {

    public static final int LISTSIZE = 1000;

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
        testPrice.setAmount(BigDecimal.ONE);

        TimeSeries timeSeries = TimeSeries.builder().time(LocalDateTime.now()).close(testPrice)
                .high(testPrice).low(testPrice).open(testPrice).volume(100).build();

        TimeSeriesJpa timeSeriesJpa = timeSeriesJpaMapper.toJpa(timeSeries);
        TimeSeries result = timeSeriesJpaMapper.fromJpa(timeSeriesJpa);

        assertEquals(timeSeries, result);
    }

    //todo rossj add stocktimeseriesdata test.

    private List retrieveTimeSeries() {

        List<TimeSeries> timeSeriesList = new ArrayList<>();

        Price testPrice = new Price();
        testPrice.setAmount(BigDecimal.ONE);

        TimeSeries timeSeries = TimeSeries.builder().time(LocalDateTime.now()).close(testPrice)
                .high(testPrice).low(testPrice).open(testPrice).volume(100).build();

        for (int i = 0; i < LISTSIZE; i++ ) {
            timeSeriesList.add(timeSeries);
        }

        return timeSeriesList;
    }
}
