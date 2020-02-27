package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;
import java.util.HashMap;


/**
 * TimeSeriesWeeklyDataSerializer.
 *
 * @author joern ross (pearlbay) 2020
 */
public class TimeSeriesWeeklyDataSerializer extends StockTimeSeriesDataCustomSerializer {

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
    HashMap<String, String> getKeyValuePairs() {
        HashMap<String, String> keyValuePairs = new HashMap<>();
        keyValuePairs.put("METADATA_IDENTIFIER", "Meta Data");
        keyValuePairs.put("TIMESERIES_IDENTIFIER", "Weekly Time Series");

        return keyValuePairs;
    }

    @Override
    public StockTimeSeriesDataDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        return serializeDto(jsonParser);
    }
}