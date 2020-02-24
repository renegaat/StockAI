package de.pearlbay.stockai.stockrepo.restclient.mapper.objectmapper;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;

public class CustomSerializerFactory {
    @FunctionalInterface
    interface SerializerFactory {
        StockTimeSeriesDataSerializer createStockTimeSeriesDataSerializer();
    }

    class TimeSeriesDailyDataSerializerFactory implements SerializerFactory {
        @Override
        public StockTimeSeriesDataSerializer createStockTimeSeriesDataSerializer() {
            return new TimeSeriesDailyDataSerializer(StockTimeSeriesDataDto.class);
        }
    }

    class TimeSeriesWeeklyDataSerializerFactory implements SerializerFactory {
        @Override
        public StockTimeSeriesDataSerializer createStockTimeSeriesDataSerializer() {
            return new TimeSeriesWeeklyDataSerializer(StockTimeSeriesDataDto.class);
        }
    }

    public SerializerFactory factory(Function function) {
        switch (function) {
            case TIME_SERIES_INTRADAY:
                break;
            case TIME_SERIES_DAILY:
                return new TimeSeriesDailyDataSerializerFactory();
            case TIME_SERIES_DAILY_ADJUSTED:
                break;
            case TIME_SERIES_WEEKLY:
                return new TimeSeriesWeeklyDataSerializerFactory();
            case TIME_SERIES_WEEKLY_ADJUSTED:
                break;
            case TIME_SERIES_MONTHLY:
                break;
            case TIME_SERIES_MONTHLY_ADJUSTED:
                break;
            default:
                return null;
        }
        return null;
    }
}
