package de.pearlbay.stockai.stockrepo.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer.CustomSerializerFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Custom RestTemplate.
 * @author joern ross (pearlbay) 2020
 */
@Component
public class StockAIRestTemplate extends RestTemplate {
    public void constructCustomRestTemplate(Function function) {

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StockTimeSeriesDataDto.class, CustomSerializerFactory.factory(function));
        mapper.registerModule(module);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);

        this.getMessageConverters().add(0, converter);
    }
}
