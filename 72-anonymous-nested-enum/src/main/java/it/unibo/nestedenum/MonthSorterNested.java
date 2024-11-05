package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            public int compare(String month1, String month2) {
                return Month.fromString(month1).getNumOfDays() - Month.fromString(month2).getNumOfDays();
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            public int compare(String month1, String month2) {
                return Month.fromString(month1).getNumber() - Month.fromString(month2).getNumber();
            }
        };
    }
}
