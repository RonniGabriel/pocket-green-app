package com.pocketgreen.gardenservice.model.enums;

public enum WaterFrequency {
    DAILY(1),
    EVERY_2_DAYS(2),
    TWICE_A_WEEK(3),
    WEEKLY(7),
    EVERY_10_DAYS(10),
    BIWEEKLY(14),
    MONTHLY(30);

    private final int days;

    WaterFrequency(int days) { this.days = days; }

    public int days() { return days; }
}
