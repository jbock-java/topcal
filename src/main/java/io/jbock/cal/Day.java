package io.jbock.cal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final class Day {
    
    private final String string;
    private final LocalDate date;

    private Day(String string, LocalDate date) {
        this.string = string;
        this.date = date;
    }

    static Day create(LocalDate date) {
        return new Day(format(date), date);
    }

    static Day dud() {
        return new Day("  ", null);
    }

    static List<Day> duds(DayOfWeek dayOfWeek) {
        List<Day> result = new ArrayList<>();
        for (int i = 0; i < dayOfWeek.getValue() - 1; i++) {
            result.add(dud());
        }
        return result;
    }

    static List<Day> duds() {
        List<Day> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            result.add(dud());
        }
        return result;
    }

    static List<Day> fill(List<Day> week) {
        List<Day> result = new ArrayList<>(week);
        while (result.size() < 7) {
            result.add(dud());
        }
        return result;
    }

    String string() {
        if (date == null) {
            return string;
        }
        if (Dates.HIGHLIGHT.contains(date)) {
            return AnsiCode.highlight(format(date));
        }
        return string;
    }

    private static String format(LocalDate date) {
        return String.format("%2d", date.getDayOfMonth());
    }
}
