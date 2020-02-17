package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.stockrepo.restclient.StockTimeSeriesRestClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations="classpath:application-test.properties")
public class StockTimeSeriesClientTest {
    @Autowired  StockTimeSeriesRestClient stockTimeSeriesRestClient;

    @Test
    public void testRetrieveStockTimeSeriesData() {

    }
}
