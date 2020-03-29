package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class CustomSerializerTest {

    public static final String PATHNAME = "src/test/resources/json/";

    @Test
    public void test_TIME_SERIES_INTRADAY_Serializer() throws IOException {

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser  = mappingJsonFactory
                .createParser(new File(PATHNAME +  "Time_Series_Intraday.json"));

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_INTRADAY);
       StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_DAILY_Serializer() throws IOException {

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser  = mappingJsonFactory
                .createParser(new File(PATHNAME +  "Time_Series_Daily.json"));

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_DAILY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }
}
