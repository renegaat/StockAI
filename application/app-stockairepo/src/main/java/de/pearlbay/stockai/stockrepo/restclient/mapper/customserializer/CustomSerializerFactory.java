package de.pearlbay.stockai.stockrepo.restclient.mapper.customserializer;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.restclient.dto.StockTimeSeriesDataDto;
/**
 * CustomSerializerFactory.
 *
 * @author joern ross (pearlbay) 2020
 */
public class CustomSerializerFactory {

    public  static StockTimeSeriesDataSerializer factory(Function function) {
        switch (function) {
            case TIME_SERIES_INTRADAY:
                break;
            case TIME_SERIES_DAILY:
                return new TimeSeriesDailyDataSerializer(StockTimeSeriesDataDto.class);
            case TIME_SERIES_DAILY_ADJUSTED:
                break;
            case TIME_SERIES_WEEKLY:
                return new TimeSeriesWeeklyDataSerializer(StockTimeSeriesDataDto.class);
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
