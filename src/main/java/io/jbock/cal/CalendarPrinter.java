package io.jbock.cal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CalendarPrinter {

    public static void main(String[] args) {
        int year = 2024;
        List<String> words = new ArrayList<>();
        for (Month m : Month.values()) {
            words.add(
                    String.format("%-20s",
                            m.getDisplayName(TextStyle.FULL, Locale.GERMANY) + " " + year));
            List<List<Day>> weeks = getWeeks(year, m);
            words.add("Mo Di Mi Do Fr Sa So");
            for (List<Day> week : weeks) {
                words.add(formatWeek(week));
            }
            words.add(" ".repeat(20));
        }
        Columns.print(words);
    }

    static List<List<Day>> getWeeks(int year, Month m) {
        LocalDate date = LocalDate.of(year, m, 1);
        List<List<Day>> result = new ArrayList<>();
        List<Day> week = new ArrayList<>(Day.duds(date.getDayOfWeek()));
        while (date.getMonth() == m) {
            week.add(Day.create(date));
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                result.add(List.copyOf(week));
                week.clear();
            }
            date = date.plusDays(1);
        }
        if (!week.isEmpty()) {
            result.add(Day.fill(week));
        }
        return result;
    }

    static String formatWeek(List<Day> week) {
        return week.stream()
                .map(Day::string)
                .collect(Collectors.joining(" "));
    }
}
