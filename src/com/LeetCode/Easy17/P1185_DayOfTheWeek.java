package com.LeetCode.Easy17;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class P1185_DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        return LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL,  Locale.getDefault());
    }
}
