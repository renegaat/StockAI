package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;
import java.util.HashMap;

/**
 * TimeSeriesIntraDayDataSerializer.
 *
 * @author joern ross (pearlbay) 2020
 */
public class TimeSeriesIntraDayDataSerializer extends StockTimeSeriesDataCustomSerializer {

    protected TimeSeriesIntraDayDataSerializer(JavaType valueType) {
        super(valueType);
    }

    public TimeSeriesIntraDayDataSerializer(Class<?> vc) {
        super(vc);
    }

    public TimeSeriesIntraDayDataSerializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    HashMap<String, String> getKeyValuePairs() {

        HashMap<String, String> keyValuePairs = new HashMap<>();

        keyValuePairs.put(METADATA_INFORMATION, "1. Information");
        keyValuePairs.put(METADATA_SYMBOL, "2. Symbol");
        keyValuePairs.put(METADATA_REFRESHED, "3. Last Refreshed");
        keyValuePairs.put(METADATA_TIMEZONE, "6. Time Zone");

        keyValuePairs.put(TIMESERIES_OPEN, "1. open");
        keyValuePairs.put(TIMESERIES_HIGH, "2. high");
        keyValuePairs.put(TIMESERIES_LOW, "3. low");
        keyValuePairs.put(TIMESERIES_CLOSE, "4. close");
        keyValuePairs.put(TIMESERIES_VOLUME, "5. volume");

        return keyValuePairs;
    }

    @Override
    public StockTimeSeriesDataDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        return serializeDto(jsonParser);
    }
}
