package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
/**
 * CustomSerializerFactory.
 *
 * @author joern ross (pearlbay) 2020
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class CustomSerializerFactory {

    public  static StockTimeSeriesDataCustomSerializer factory(Function function) {
        switch (function) {
            case TIME_SERIES_INTRADAY:
                return new TimeSeriesIntraDayDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_DAILY:
                return new TimeSeriesDailyDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_DAILY_ADJUSTED:
                return new TimeSeriesDailyAdjustedDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_WEEKLY:
                return new TimeSeriesWeeklyDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_WEEKLY_ADJUSTED:
                return new TimeSeriesWeeklyAdjustedDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_MONTHLY:
                return new TimeSeriesMonthlyDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_MONTHLY_ADJUSTED:
                return new TimeSeriesMonthlyAdjustedDataSerializer(StockTimeSeriesDataDto.class);
            default:
                throw new RuntimeException("Configuration Error");
        }
    }
}
