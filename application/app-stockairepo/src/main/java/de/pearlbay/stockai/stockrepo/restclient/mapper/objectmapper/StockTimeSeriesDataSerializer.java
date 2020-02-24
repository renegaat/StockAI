package de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class StockTimeSeriesDataSerializer extends StdDeserializer<StockTimeSeriesDataDto> {

    public static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataSerializer.class);
    
    protected StockTimeSeriesDataSerializer(JavaType valueType) {
        super(valueType);
    }

    public StockTimeSeriesDataSerializer(Class<?> vc) {
        super(vc);
    }

    public StockTimeSeriesDataSerializer(StdDeserializer<?> src) {
        super(src);
    }
}