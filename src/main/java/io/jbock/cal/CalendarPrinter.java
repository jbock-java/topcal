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
        for (Month m : Month.values()) {
            System.out.println(m.getDisplayName(TextStyle.FULL, Locale.GERMANY) + " " + year);
            List<List<Day>> weeks = getWeeks(year, m);
            System.out.println("Mo Di Mi Do Fr Sa So");
            for (List<Day> week : weeks) {
                System.out.println(formatWeek(week));
            }
            System.out.println();
        }
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
            result.add(List.copyOf(week));
        }
        return result;
    }

    static String formatWeek(List<Day> week) {
        return week.stream()
                .map(Day::string)
                .collect(Collectors.joining(" "));
    }
}
