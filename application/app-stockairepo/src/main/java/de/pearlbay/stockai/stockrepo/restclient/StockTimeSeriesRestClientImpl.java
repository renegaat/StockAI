package de.pearlbay.stockai.stockrepo.restclient;


import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.Interval;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

/**
 * StockTimeSeriesRestClient
 * Retrieves stockdata json from service.
 *
 * @author joern ross (pearlbay) 2020
 */
@Component
public class StockTimeSeriesRestClientImpl implements StockTimeSeriesRestClient {


    @Autowired
    private StockAIRestTemplate stockAIRestTemplate;

    @Value("${alphavantage.apiUrl}")
    private String apiUrl;

    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesRestClientImpl.class);


    @Override
    public StockTimeSeriesDataDto retrieveStockTimeSeriesData(String apiKey, String symbol,
                                                              Function function, OutputSize outputSize,
                                                              Interval interval) {
        String url = apiUrl
                + "function=" + function.name()
                + "&symbol=" + symbol
                + "&apikey=" + apiKey
                + "&outputsize=" + outputSize;

        if (interval != null) {
            url = url + "&interval=" + interval.getMinuteValue();
        }

        stockAIRestTemplate.constructCustomRestTemplate(function);

        StockTimeSeriesDataDto stockTimeSeriesDataDto = null;

        try {
            stockTimeSeriesDataDto = stockAIRestTemplate.getForObject(url, StockTimeSeriesDataDto.class);
        } catch (RestClientException e) {
            LOG.error("RestClient Exception : " + e.getLocalizedMessage());
        }

        return stockTimeSeriesDataDto;
    }

}