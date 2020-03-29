package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class CustomSerializerTest {

    @Test
    public void test_TIME_SERIES_INTRADAY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/Time_Series_Intraday.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser  = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_INTRADAY);
       StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_DAILY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/Time_Series_Daily.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser  = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_DAILY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }
}
