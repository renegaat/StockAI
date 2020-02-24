package de.pearlbay.stockai.stockrepo.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.common.enums.OutputSize;
import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper.CustomSerializerFactory;
import de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper.StockTimeSeriesDataSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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

       /* ObjectMapper objectMapper = new ObjectMapper();
        CustomSerializerFactory customSerializerFactory = new CustomSerializerFactory();
        stockTimeSeriesDataSerializer = customSerializerFactory.factory(function);
         
         
        
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(StockTimeSeriesDataDto.class, customSerializerFactory.factory(function).
        mapper.registerModule(module);
        */
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl
                + "function=" + function.name()
                + "&symbol=" + symbol
                + "&apikey=" + apiKey
                + "&outputsize=" + outputSize;

        
        
        
        MetaDataDto metaDataDto = restTemplate.getForObject(url, MetaDataDto.class);
        //todo create object mapper factory : https://en.wikipedia.org/wiki/Abstract_factory_pattern
        //todo create custom deserializer and register by objectmapper https://www.baeldung.com/jackson-deserialization
        //todo add mapper to template https://dzone.com/articles/configuring-a-custom-objectmapper-for-spring-restt

        
        
        
        
        return null;
    }
}