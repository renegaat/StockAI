package de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;

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
            throws IOException, JsonProcessingException {
        LOG.info("Entered TimeSeriesDailyDataSerializer deserializer");
        return null;
    }
}