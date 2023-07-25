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
        int year = 2023;
        List<String> words = new ArrayList<>();
        int kw = 1;
        for (Month m : Month.values()) {
            words.add(
                    String.format("   %-20s",
                            m.getDisplayName(TextStyle.FULL, Locale.GERMANY) + " " + year));
            List<Week> weeks = getWeeks(kw, year, m);
            kw += weeks.stream().mapToInt(Week::kwIncrement).sum();
            words.add("   Mo Di Mi Do Fr Sa So");
            for (Week week : weeks) {
                words.add(formatWeek(week));
            }
        }
        printColumns(words);
    }

    private static void printColumns(List<String> words) {
        List<String> buffer = new ArrayList<>();
        for (String word : words) {
            buffer.add(word);
            if (buffer.size() == 24) {
                Columns.print(buffer);
                System.out.println();
                System.out.flush();
                buffer.clear();
            }
        }
    }

    static List<Week> getWeeks(int kw, int year, Month m) {
        LocalDate date = LocalDate.of(year, m, 1);
        List<Week> result = new ArrayList<>();
        List<Day> week = new ArrayList<>(Day.duds(date.getDayOfWeek()));
        while (date.getMonth() == m) {
            week.add(Day.create(date));
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                result.add(Week.create(kw, List.copyOf(week)));
                kw++;
                week.clear();
            }
            date = date.plusDays(1);
        }
        if (!week.isEmpty()) {
            result.add(Week.create(kw, Day.fill(week)));
        }
        while (result.size() < 6) {
            result.add(Week.create(Day.duds()));
        }
        return result;
    }

    static String formatWeek(Week week) {
        String kwString = week.kw.stream()
                .mapToObj(kw -> AnsiCode.gray(String.format("%02d", kw)))
                .findFirst()
                .orElse("  ");
        return kwString + ' ' + week.days.stream()
                .map(Day::string)
                .collect(Collectors.joining(" "));
    }
}
