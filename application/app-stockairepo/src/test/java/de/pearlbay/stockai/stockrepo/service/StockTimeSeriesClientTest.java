package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:application-test.properties")
public class StockTimeSeriesClientTest {

    @Test
    public void testRetrieveStockTimeSeriesData() {
        //todo jross finish test
        StockTimeSeriesClient stockTimeSeriesClient = new StockTimeSeriesClientImpl();
    }
}
