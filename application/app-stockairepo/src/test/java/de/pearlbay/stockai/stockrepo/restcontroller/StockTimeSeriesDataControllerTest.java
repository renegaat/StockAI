package de.pearlbay.stockai.stockrepo.restcontroller;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import de.pearlbay.stockai.stockrepo.restcontroller.v1.StockTimeSeriesDataController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StockTimeSeriesDataControllerTest {

    public static final String SYMBOL = "MSFT";
    public static final String DATE = "2019-06-06 11:30:00";
    public static final String DATEPATTERN = "yyyy-MM-dd HH:mm:ss";


    @Mock
    StockTimeSeriesDataService stockTimeSeriesDataService;


    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunction() {

        when(stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunction(SYMBOL, Function.TIME_SERIES_WEEKLY))
                .thenReturn(StockTimeSeriesData.builder().build());

        StockTimeSeriesDataController stockTimeSeriesDataController
                = new StockTimeSeriesDataController(stockTimeSeriesDataService);

        ResponseEntity<StockTimeSeriesData> result = stockTimeSeriesDataController
                .retrieveStockTimeSeriesDataBySymbolAndFunction(SYMBOL, Function.TIME_SERIES_WEEKLY);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunctionNotFound() {

        when(stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunction(SYMBOL, Function.TIME_SERIES_WEEKLY))
                .thenReturn(null);

        StockTimeSeriesDataController stockTimeSeriesDataController
                = new StockTimeSeriesDataController(stockTimeSeriesDataService);

        ResponseEntity<StockTimeSeriesData> result = stockTimeSeriesDataController
                .retrieveStockTimeSeriesDataBySymbolAndFunction(SYMBOL, Function.TIME_SERIES_WEEKLY);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunctionAndDate() {


        DateTimeFormatter formater = DateTimeFormatter.ofPattern(DATEPATTERN);

        LocalDateTime date = LocalDateTime.parse(DATE, formater);

        when(stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(SYMBOL
                        , Function.TIME_SERIES_WEEKLY, date, date))
                .thenReturn(StockTimeSeriesData.builder().build());

        StockTimeSeriesDataController stockTimeSeriesDataController
                = new StockTimeSeriesDataController(stockTimeSeriesDataService);

        ResponseEntity<StockTimeSeriesData> result = stockTimeSeriesDataController
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(SYMBOL
                        , Function.TIME_SERIES_WEEKLY, DATE, DATE);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunctionAndDateNotFound() {


        DateTimeFormatter formater = DateTimeFormatter.ofPattern(DATEPATTERN);

        LocalDateTime date = LocalDateTime.parse(DATE, formater);

        when(stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(SYMBOL
                        , Function.TIME_SERIES_WEEKLY, date, date))
                .thenReturn(null);

        StockTimeSeriesDataController stockTimeSeriesDataController
                = new StockTimeSeriesDataController(stockTimeSeriesDataService);

        ResponseEntity<StockTimeSeriesData> result = stockTimeSeriesDataController
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(SYMBOL
                        , Function.TIME_SERIES_WEEKLY, DATE, DATE);

        assertEquals(HttpStatus.NOT_FOUND,
                result.getStatusCode());
    }
}
