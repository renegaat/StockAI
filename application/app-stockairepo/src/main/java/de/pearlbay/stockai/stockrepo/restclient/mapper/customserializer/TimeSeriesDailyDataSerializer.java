package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;


/**
 * TimeSeriesDailyDataSerializer.
 * @author joern ross (pearlbay) 2020
 */
public class TimeSeriesDailyDataSerializer extends StockTimeSeriesDataSerializer {

    protected TimeSeriesDailyDataSerializer(JavaType valueType) {
        super(valueType);
    }

    public TimeSeriesDailyDataSerializer(Class<?> vc) {
        super(vc);
    }

    public TimeSeriesDailyDataSerializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public StockTimeSeriesDataDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        LOG.info("Entered TimeSeriesDailyDataSerializer deserializer");
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return StockTimeSeriesDataDto.builder().build();
    }
}