package io.jbock.cal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Dates {

    static final Set<LocalDate> HIGHLIGHT = createHighlight();

    private static Set<LocalDate> createHighlight2023() {
        Set<LocalDate> result = new HashSet<>();
        result.addAll(range(LocalDate.parse("2023-07-06"), LocalDate.parse("2023-07-26")));
        result.addAll(pair(LocalDate.parse("2023-08-26")));
        result.addAll(pair(LocalDate.parse("2023-09-09")));
        result.addAll(pair(LocalDate.parse("2023-09-23")));
        result.addAll(pair(LocalDate.parse("2023-10-07")));
        result.addAll(range(LocalDate.parse("2023-10-14"), LocalDate.parse("2023-10-21")));
        result.addAll(pair(LocalDate.parse("2023-11-04")));
        result.addAll(pair(LocalDate.parse("2023-11-18")));
        result.addAll(pair(LocalDate.parse("2023-12-02")));
        result.addAll(pair(LocalDate.parse("2023-12-16")));
        result.addAll(range(LocalDate.parse("2023-12-25"), LocalDate.parse("2023-12-30")));
        return result;
    }

    private static Set<LocalDate> createHighlight() {
        Set<LocalDate> result = new HashSet<>();
        result.addAll(pair(LocalDate.parse("2024-01-20")));
        result.addAll(range(LocalDate.parse("2024-02-01"), LocalDate.parse("2024-02-04")));
        result.addAll(pair(LocalDate.parse("2024-02-17")));
        result.addAll(pair(LocalDate.parse("2024-03-02")));
        result.addAll(range(LocalDate.parse("2024-03-24"), LocalDate.parse("2024-04-01")));
        result.addAll(pair(LocalDate.parse("2024-04-13")));
        result.addAll(pair(LocalDate.parse("2024-04-27")));
        result.addAll(range(LocalDate.parse("2024-05-09"), LocalDate.parse("2024-05-12")));
        result.addAll(pair(LocalDate.parse("2024-05-25")));
        result.addAll(pair(LocalDate.parse("2024-06-08")));
        result.addAll(range(LocalDate.parse("2024-07-14"), LocalDate.parse("2024-08-04")));
        result.addAll(pair(LocalDate.parse("2024-08-17")));
        result.addAll(pair(LocalDate.parse("2024-08-31")));
        result.addAll(pair(LocalDate.parse("2024-09-14")));
        result.addAll(pair(LocalDate.parse("2024-09-28")));
        result.addAll(range(LocalDate.parse("2024-10-12"), LocalDate.parse("2024-10-20")));
        result.addAll(pair(LocalDate.parse("2024-10-26")));
        result.addAll(pair(LocalDate.parse("2024-11-09")));
        result.addAll(pair(LocalDate.parse("2024-11-23")));
        result.addAll(pair(LocalDate.parse("2024-12-07")));
        result.addAll(range(LocalDate.parse("2024-12-25"), LocalDate.parse("2024-12-30")));
        return result;
    }

    static List<LocalDate> pair(LocalDate date) {
        return range(date, date.plusDays(1));
    }

    static List<LocalDate> range(LocalDate from, LocalDate to) {
        LocalDate d = from;
        List<LocalDate> result = new ArrayList<>();
        do {
            result.add(d);
            d = d.plusDays(1);
        } while (!d.isAfter(to));
        return result;
    }
}
