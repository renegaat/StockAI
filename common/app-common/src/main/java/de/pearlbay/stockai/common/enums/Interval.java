package de.pearlbay.stockai.common.enums;


/**
 * Interval.
 * @author joern ross (pearlbay) 2020
 */
public enum Interval {
    ONE_MINUTE("1min"), FIVE_MINUTE("5min"), FIFTEEN_MINUTE("15min"), THIRTY_MINUTE("30min"), SIXTY_MINUTE("60min");

    private String minuteValue;

    Interval(String minuteValue) {
        this.minuteValue = minuteValue;
    }

    public String getMinuteValue() {
        return this.minuteValue;
    }
}
