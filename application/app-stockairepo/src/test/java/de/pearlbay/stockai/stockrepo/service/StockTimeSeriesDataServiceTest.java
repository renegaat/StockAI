package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Currency;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Market;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.repository.MetaDataJpa;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import de.pearlbay.stockai.stockrepo.repository.TimeSeriesJpa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StockTimeSeriesDataServiceTest {

    public static final String SYMBOL = "symbol";
    public static final Function TIME_SERIES_DAILY = Function.TIME_SERIES_DAILY;
    @Mock
    StockTimeSeriesDataRepository stockTimeSeriesDataRepository;

    @InjectMocks
    StockTimeSeriesDataServiceImpl stockTimeSeriesDataService;

    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunction() {
        when(stockTimeSeriesDataRepository.findBySymbolAndFunction(SYMBOL, TIME_SERIES_DAILY))
                .thenReturn(StockTimeSeriesDataJpa.builder().build());

        StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunction(SYMBOL, TIME_SERIES_DAILY);
        assertNotNull(stockTimeSeriesData);
    }

    @Test
    public void testCreateOrUpdateStockTimeSeriesData() {
        when(stockTimeSeriesDataRepository.save(any(StockTimeSeriesDataJpa.class)))
                .thenReturn(StockTimeSeriesDataJpa.builder().build());
        StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesDataService
                .createOrUpdateStockTimeSeriesData(StockTimeSeriesData.builder().build());
        assertNotNull(stockTimeSeriesData);
    }

    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunctionAndDate() {

        MetaDataJpa metaData = MetaDataJpa.builder()
                .information("Information")
                .lastRefreshed(LocalDateTime.now())
                .symbol(SYMBOL)
                .timeZone("Australia/Darwin")
                .build();

        StockTimeSeriesDataJpa stockTimeSeriesData = StockTimeSeriesDataJpa.builder()
                .metaData(metaData)
                .newData(true)
                .timeSeries(retrieveTimeSeriesList()).stockName("Stockname")
                .currency(Currency.BRL)
                .function(TIME_SERIES_DAILY)
                .market(Market.CAD)
                .build();

        when(stockTimeSeriesDataRepository.findBySymbolAndFunction(SYMBOL, TIME_SERIES_DAILY))
                .thenReturn(stockTimeSeriesData);

        StockTimeSeriesData result = stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(SYMBOL, TIME_SERIES_DAILY
                        , LocalDateTime.of(2020, 1, 5, 12, 0)
                        , LocalDateTime.of(2020, 2, 5, 12, 0));

        assertNotNull(result);
        assertEquals(result.getTimeSeries().size(), 1);
    }
    
    @Test
    public void testDeleteStockTimeSeriesDataBySymbolAndFunction() {
        stockTimeSeriesDataService.deleteStockTimeSeriesDataBySymbolAndFunction("symbol"
                , TIME_SERIES_DAILY);
    }
    
    private List<TimeSeriesJpa> retrieveTimeSeriesList() {

        List<TimeSeriesJpa> timeSeriesList = new ArrayList<>();

        BigDecimal testPrice = BigDecimal.ONE;

        TimeSeriesJpa timeSeriesA = TimeSeriesJpa.builder()
                .time(LocalDateTime.of(2020, 1, 1, 12, 00))
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        TimeSeriesJpa timeSeriesB = TimeSeriesJpa.builder()
                .time(LocalDateTime.of(2020, 2, 1, 12, 00))
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        TimeSeriesJpa timeSeriesC = TimeSeriesJpa.builder()
                .time(LocalDateTime.of(2020, 3, 1, 12, 00))
                .close(testPrice)
                .high(testPrice)
                .low(testPrice)
                .open(testPrice)
                .volume(100)
                .build();

        timeSeriesList.add(timeSeriesA);
        timeSeriesList.add(timeSeriesB);
        timeSeriesList.add(timeSeriesC);

        return timeSeriesList;
    }
}
