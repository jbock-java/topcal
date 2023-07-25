package io.jbock.cal;

import java.util.List;
import java.util.OptionalInt;

class Week {
    
    final OptionalInt kw;
    final List<Day> days;

    private Week(OptionalInt kw, List<Day> days) {
        this.kw = kw;
        this.days = days;
    }

    static Week create(int kw, List<Day> days) {
        return new Week(OptionalInt.of(kw), days);
    }

    static Week create(List<Day> days) {
        return new Week(OptionalInt.empty(), days);
    }

    int kwIncrement() {
        return days.stream().anyMatch(Day::isSunday) ? 1 : 0;
    }
}
