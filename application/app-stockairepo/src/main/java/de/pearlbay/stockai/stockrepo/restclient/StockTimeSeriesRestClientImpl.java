package de.pearlbay.stockai.stockrepo.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer.CustomSerializerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * StockTimeSeriesRestClient
 * Retrieves stockdata json from service.
 *
 * @author joern ross (pearlbay) 2020
 */
@Component
public class StockTimeSeriesRestClientImpl implements StockTimeSeriesRestClient {

    @Value("${alphavantage.apiUrl}")
    private String apiUrl;

    @Override
    public StockTimeSeriesDataDto retrieveStockTimeSeriesDataDto(String apiKey, String symbol,
                                                                 Function function, OutputSize outputSize) {

        //todo create object mapper factory : https://en.wikipedia.org/wiki/Abstract_factory_pattern
        //todo create custom deserializer and register by objectmapper https://www.baeldung.com/jackson-deserialization
        //todo add mapper to template https://dzone.com/articles/configuring-a-custom-objectmapper-for-spring-restt

        String url = apiUrl
                + "function=" + function.name()
                + "&symbol=" + symbol
                + "&apikey=" + apiKey
                + "&outputsize=" + outputSize;

        RestTemplate restTemplate = constructCustomRestTemplate(function);

        StockTimeSeriesDataDto stockTimeSeriesDataDto = null;

        try {
            stockTimeSeriesDataDto = restTemplate.getForObject(url, StockTimeSeriesDataDto.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return stockTimeSeriesDataDto;
    }

    private RestTemplate constructCustomRestTemplate(Function function) {

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StockTimeSeriesDataDto.class, CustomSerializerFactory.factory(function));
        mapper.registerModule(module);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, converter);

        return restTemplate;
    }
}