package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.repository.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.repository.StockTimeSeriesDataJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StockTimeSeriesDataServiceTest {
    
    @Mock
    StockTimeSeriesDataRepository stockTimeSeriesDataRepository;
    
    @InjectMocks
    StockTimeSeriesDataServiceImpl stockTimeSeriesDataService;
    
    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunction(){
        when(stockTimeSeriesDataRepository.findBySymbolAndFunction("symbol", Function.TIME_SERIES_DAILY))
                .thenReturn(StockTimeSeriesDataJpa.builder().build());

        StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunction("symbol", Function.TIME_SERIES_DAILY);
       assertNotNull(stockTimeSeriesData);
    }
    
    @Test
    public void testCreateOrUpdateStockTimeSeriesData(){
        when(stockTimeSeriesDataRepository.save(any(StockTimeSeriesDataJpa.class)))
                .thenReturn(StockTimeSeriesDataJpa.builder().build());
        StockTimeSeriesData stockTimeSeriesData = stockTimeSeriesDataService
                .createOrUpdateStockTimeSeriesData(StockTimeSeriesData.builder().build());
        assertNotNull(stockTimeSeriesData);
    }
    
    @Test
    public void testRetrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(){
    // TODO test retrieve by date function
    }
    
    @Test
    public void testDeleteStockTimeSeriesDataBySymbolAndFunction(){
        stockTimeSeriesDataService.deleteStockTimeSeriesDataBySymbolAndFunction("symbol"
                , Function.TIME_SERIES_DAILY);    
    }
}
