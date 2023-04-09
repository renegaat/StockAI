package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomSerializerTest {

    @Test
    public void test_TIME_SERIES_INTRADAY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesintraday.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_INTRADAY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_DAILY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesdaily.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_DAILY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_DAILY_ADJUSTED_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesdailyadjusted.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_DAILY_ADJUSTED);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_WEEKLY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesweekly.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_WEEKLY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_WEEKLY_ADJUSTED_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesweeklyadjusted.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_WEEKLY_ADJUSTED);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

    @Test
    public void test_TIME_SERIES_MONTHLY_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesmonthly.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_MONTHLY);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }
    @Test
    public void test_TIME_SERIES_MONTHLY_ADJUSTED_Serializer() throws IOException {

        File jsonFile = ResourceUtils.getFile(this.getClass()
                .getResource("/json/timeseriesmonthlyadjusted.json"));

        MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = mappingJsonFactory
                .createParser(jsonFile);

        StockTimeSeriesDataCustomSerializer stockTimeSeriesDataCustomSerializer = CustomSerializerFactory
                .factory(Function.TIME_SERIES_MONTHLY_ADJUSTED);
        StockTimeSeriesDataDto stockTimeSeriesDataDto = stockTimeSeriesDataCustomSerializer.serializeDto(jsonParser);

        assertNotNull(stockTimeSeriesDataDto);
    }

}
