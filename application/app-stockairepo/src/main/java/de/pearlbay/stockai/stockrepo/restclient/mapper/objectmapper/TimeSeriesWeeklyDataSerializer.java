package de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;

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
            throws IOException, JsonProcessingException {
        LOG.info("Entered TimeSeriesWeeklyDataSerializer deserializer");
        return null;
    }
}