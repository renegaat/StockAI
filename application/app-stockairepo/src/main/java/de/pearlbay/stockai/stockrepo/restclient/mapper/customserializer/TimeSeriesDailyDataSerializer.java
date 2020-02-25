package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

import java.io.IOException;


/**
 * TimeSeriesDailyDataSerializer.
 *
 * @author joern ross (pearlbay) 2020
 */
public class TimeSeriesDailyDataSerializer extends StockTimeSeriesDataSerializer {

    public static final String METADATA_IDENTIFIER = "Meta Data";
    public static final String TIMESERIES_IDENTIFIER = "Time Series (Daily)";

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
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        JsonNode metaDataNode = node.get(METADATA_IDENTIFIER);

        MetaDataDto metaDataDto =
                MetaDataDto.builder().information(metaDataNode.get("1. Information").asText())
                        .symbol(metaDataNode.get("2. Symbol").asText())
                        .lastRefreshed(metaDataNode.get("3. Last Refreshed").asText())
                        .timeZone(metaDataNode.get("5. Time Zone").asText())
                        .build();

        return StockTimeSeriesDataDto.builder().metaDataDto(metaDataDto).build();
    }
}