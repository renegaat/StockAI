package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

        import com.fasterxml.jackson.core.JsonParser;
        import com.fasterxml.jackson.databind.DeserializationContext;
        import com.fasterxml.jackson.databind.JavaType;
        import com.fasterxml.jackson.databind.JsonNode;
        import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
        import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
        import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
        import de.pearlbay.stockai.stockrepo.restclient.dto.TimeSeriesDto;

        import java.io.IOException;
        import java.math.BigDecimal;
        import java.math.MathContext;
        import java.util.*;

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
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);

        JsonNode metaDataNode = rootNode.get(METADATA_IDENTIFIER);

        MetaDataDto metaDataDto = null;

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

        Iterator<Map.Entry<String, JsonNode>> iterator = rootNode.get(TIMESERIES_IDENTIFIER).fields();

        List<TimeSeriesDto> timeSeriesDtos = new ArrayList<>();

        while (iterator.hasNext()) {

            Map.Entry<String, JsonNode> entry = iterator.next();

            String date = entry.getKey();

            BigDecimal open = null;
            BigDecimal high = null;
            BigDecimal low  = null;
            BigDecimal close  = null;
            double volume  = 0;

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