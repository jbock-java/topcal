package io.jbock.cal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final class Day {
    
    private final String string;

    private Day(String string) {
        this.string = string;
    }

    static Day create(LocalDate date) {
        return new Day(String.format("%2d", date.getDayOfMonth()));
    }

    static Day dud() {
        return new Day("  ");
    }

    static List<Day> duds(DayOfWeek dayOfWeek) {
        List<Day> result = new ArrayList<>();
        for (int i = 0; i < dayOfWeek.getValue() - 1; i++) {
            result.add(dud());
        }
        return result;
    }

    String string() {
        return string;
    }
}
