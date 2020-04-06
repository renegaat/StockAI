package de.pearlbay.stockai.stockrepo.restclient;

import de.pearlbay.stockai.common.domain.Price;
import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.TimeSeries;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.service.mapper.StockTimeSeriesDataDtoMapperImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DTOMapperTest {

    public static final int LISTSIZE = 10;

    public static final LocalDateTime LAST_REFRESHED
            = LocalDateTime.of(2000, 1, 1, 1, 1);

    @Test
    public void shouldMapDataToDtoAndBack() {

        StockTimeSeriesDataDtoMapperImpl stockTimeSeriesDataDtoMapper = new StockTimeSeriesDataDtoMapperImpl();

        MetaData metaData = MetaData.builder()
                .information("Information")
                .lastRefreshed(LAST_REFRESHED)
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


        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataDtoMapper.toDto(stockTimeSeriesData);
        StockTimeSeriesData result = stockTimeSeriesDataDtoMapper.fromDto(stockTimeSeriesDataDto);

        assertEquals(stockTimeSeriesData.getMetaData(), result.getMetaData());
        assertEquals(stockTimeSeriesData.getTimeSeries(), result.getTimeSeries());
    }

    private List retrieveTimeSeriesList() {

        List<TimeSeries> timeSeriesList = new ArrayList<>();

        Price testPrice = new Price();
        testPrice.setValue(BigDecimal.ONE);

        TimeSeries timeSeries = TimeSeries.builder()
                .time(LAST_REFRESHED)
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        for (int i = 0; i < LISTSIZE; i++) {
            timeSeriesList.add(timeSeries);
        }

        return timeSeriesList;
    }
}
