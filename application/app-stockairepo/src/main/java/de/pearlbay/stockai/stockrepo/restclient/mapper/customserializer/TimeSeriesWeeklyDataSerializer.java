package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;


/**
 * TimeSeriesWeeklyDataSerializer.
 * @author joern ross (pearlbay) 2020
 */
public class TimeSeriesWeeklyDataSerializer extends StockTimeSeriesDataSerializer {

    protected TimeSeriesWeeklyDataSerializer(JavaType valueType) {
        super(valueType);
    }

    public TimeSeriesWeeklyDataSerializer(Class<?> vc) {
        super(vc);
    }

    public TimeSeriesWeeklyDataSerializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public StockTimeSeriesDataDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        LOG.info("Entered TimeSeriesWeeklyDataSerializer deserializer");
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return StockTimeSeriesDataDto.builder().build();
    }
}