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

        JsonNode metaDataNode = rootNode.get(keyValuePair.get("METADATA_IDENTIFIER"));

        MetaDataDto metaDataDto;

        try {
            metaDataDto = MetaDataDto.builder().information(metaDataNode.get("1. Information").asText())
                    .symbol(metaDataNode.get("2. Symbol").asText())
                    .lastRefreshed(metaDataNode.get("3. Last Refreshed").asText())
                    .timeZone(metaDataNode.get("5. Time Zone").asText())
                    .build();
        } catch (Exception e) {
            LOG.error("Serialization Error in Custom Serializer");
            throw new RuntimeException("Serializer Error");
        }

        Iterator<Map.Entry<String, JsonNode>> iterator = rootNode.get("TIMESERIES_IDENTIFIER").fields();

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
                open = new BigDecimal(entry.getValue().get("1. open").asDouble(), MathContext.DECIMAL32);
                high = new BigDecimal(entry.getValue().get("2. high").asDouble(), MathContext.DECIMAL32);
                low = new BigDecimal(entry.getValue().get("3. low").asDouble(), MathContext.DECIMAL32);
                close = new BigDecimal(entry.getValue().get("4. close").asDouble(), MathContext.DECIMAL32);
                volume = entry.getValue().get("5. volume").asDouble();

            } catch (Exception e) {
                LOG.error("Serialization Error in Custom Serializer");
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
}