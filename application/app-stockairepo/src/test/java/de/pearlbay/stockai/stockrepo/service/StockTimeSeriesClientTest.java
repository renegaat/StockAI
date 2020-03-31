package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Interval;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import de.pearlbay.stockai.stockrepo.restclient.StockAIRestTemplate;
import de.pearlbay.stockai.stockrepo.restclient.StockTimeSeriesRestClient;
import de.pearlbay.stockai.stockrepo.restclient.StockTimeSeriesRestClientImpl;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class StockTimeSeriesClientTest {

    @Mock
    StockAIRestTemplate stockAIRestTemplate;

    @InjectMocks
    StockTimeSeriesRestClientImpl stockTimeSeriesRestClient = new StockTimeSeriesRestClientImpl();

    @Test
    public void testRetrieveStockTimeSeriesData() {

        when(stockAIRestTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(StockTimeSeriesDataDto.builder().build());

        StockTimeSeriesDataDto stockTimeSeriesDataDto
                = stockTimeSeriesRestClient.retrieveStockTimeSeriesData("APIKEY"
                , "SYMBOL", Function.TIME_SERIES_INTRADAY
                , OutputSize.COMPACT, Interval.FIVE_MINUTE);

        assertNotNull(stockTimeSeriesDataDto);
    }
}
