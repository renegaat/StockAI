package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import de.pearlbay.stockai.stockrepo.restclient.dto.TimeSeriesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

/**
 * StockTimeSeriesDataSerializer abstract.
 *
 * @author joern ross (pearlbay) 2020
 */
public abstract class StockTimeSeriesDataCustomSerializer extends StdDeserializer<StockTimeSeriesDataDto> {

    public static final String METADATA_IDENTIFIER = "METADATA_IDENTIFIER";
    public static final String METADATA_INFORMATION = "METADATA_INFORMATION";
    public static final String METADATA_SYMBOL = "METADATA_SYMBOL";
    public static final String METADATA_REFRESHED = "METADATA_REFRESHED";
    public static final String METADATA_TIMEZONE = "METADATA_TIMEZONE";
    public static final String TIMESERIES_IDENTIFIER = "TIMESERIES_IDENTIFIER";
    public static final String TIMESERIES_OPEN = "TIMESERIES_OPEN";
    public static final String TIMESERIES_HIGH = "TIMESERIES_HIGH";
    public static final String TIMESERIES_LOW = "TIMESERIES_LOW";
    public static final String TIMESERIES_CLOSE = "TIMESERIES_CLOSE";
    public static final String TIMESERIES_VOLUME = "TIMESERIES_VOLUME";

    public static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataCustomSerializer.class);

    protected StockTimeSeriesDataCustomSerializer(JavaType valueType) {
        super(valueType);
    }

    public StockTimeSeriesDataCustomSerializer(Class<?> vc) {
        super(vc);
    }

    public StockTimeSeriesDataCustomSerializer(StdDeserializer<?> src) {
        super(src);
    }

    abstract HashMap<String, String> getKeyValuePairs();


    protected StockTimeSeriesDataDto serializeDto(JsonParser jsonParser) throws IOException {

        HashMap<String, String> keyValuePair = getKeyValuePairs();

        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode metaDataNode = rootNode.get(keyValuePair.get(METADATA_IDENTIFIER));

        MetaDataDto metaDataDto = getMetaDataDto(keyValuePair, metaDataNode);

        Iterator<Map.Entry<String, JsonNode>> iterator = rootNode.get(keyValuePair
                .get(TIMESERIES_IDENTIFIER)).fields();

        List<TimeSeriesDto> timeSeriesDtos = new ArrayList<>();

        while (iterator.hasNext()) {

            Map.Entry<String, JsonNode> entry = iterator.next();

            String date = entry.getKey();

            BigDecimal open = null;
            BigDecimal high = null;
            BigDecimal low = null;
            BigDecimal close = null;
            double volume = 0;

            try {
                open = new BigDecimal(entry.getValue()
                        .get(keyValuePair.get(TIMESERIES_OPEN)).asDouble(), MathContext.DECIMAL32);
                high = new BigDecimal(entry.getValue()
                        .get(keyValuePair.get(TIMESERIES_HIGH)).asDouble(), MathContext.DECIMAL32);
                low = new BigDecimal(entry.getValue()
                        .get(keyValuePair.get(TIMESERIES_LOW)).asDouble(), MathContext.DECIMAL32);
                close = new BigDecimal(entry.getValue()
                        .get(keyValuePair.get(TIMESERIES_CLOSE)).asDouble(), MathContext.DECIMAL32);
                volume = entry.getValue().get(keyValuePair.get(TIMESERIES_VOLUME)).asDouble();

            } catch (Exception e) {
                LOG.error("Serialization Error in TimeSeries Custom Serializer");
                throw new RuntimeException("Serializer Error");
            }

            timeSeriesDtos.add(TimeSeriesDto.builder()
                    .time(date)
                    .open(open)
                    .high(high)
                    .close(close)
                    .low(low)
                    .volume(volume)
                    .build());
        }

        return StockTimeSeriesDataDto.builder()
                .metaDataDto(metaDataDto)
                .timeSeriesDtoList(timeSeriesDtos)
                .build();
    }

    private MetaDataDto getMetaDataDto(HashMap<String, String> keyValuePair, JsonNode metaDataNode) {
        MetaDataDto metaDataDto;

        try {
            metaDataDto = MetaDataDto.builder()
                    .information(metaDataNode.get(keyValuePair.get(METADATA_INFORMATION)).asText())
                    .symbol(metaDataNode.get(keyValuePair.get(METADATA_SYMBOL)).asText())
                    .lastRefreshed(metaDataNode.get(keyValuePair.get(METADATA_REFRESHED)).asText())
                    .timeZone(metaDataNode.get(keyValuePair.get(METADATA_TIMEZONE)).asText())
                    .build();
        } catch (Exception e) {
            LOG.error("Serialization Error in MetaData Custom Serializer");
            throw new RuntimeException("Serializer Error");
        }
        return metaDataDto;
    }
}