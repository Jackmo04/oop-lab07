package it.unibo.nestedenum;

public enum Month {
    JANUARY(1, "january", 31, "ja"),
    FEBRUARY(2, "february", 28, "f"),
    MARCH(3, "march", 31, "mar"),
    APRIL(4, "april", 30, "ap"),
    MAY(5, "may", 31, "may"),
    JUNE(6, "june", 30, "jun"),
    JULY(7, "july", 31, "jul"),
    AUGUST(8, "august", 31, "au"),
    SEPTEMBER(9, "september", 30, "s"),
    OCTOBER(10, "october", 31, "o"),
    NOVEMBER(11, "november", 30, "n"),
    DECEMBER(12, "december", 31, "d");

    private final int number;
    private final String lowerCaseName;
    private final int numOfDays;
    private final String shortestUniqueName;

    private Month(final int number, final String lowerCaseName, final int numOfDays, final String shortestUniqueName) {
        this.number = number;
        this.lowerCaseName = lowerCaseName;
        this.numOfDays = numOfDays;
        this.shortestUniqueName = shortestUniqueName;
    }

    public int getNumber() {
        return this.number;
    }

    public int getNumOfDays() {
        return this.numOfDays;
    }

    public static Month fromString(final String month) {
        var lcMonth = month.toLowerCase();

        for (Month m : Month.values()) {
            // Search for complete name matches
            if (lcMonth.equals(m.lowerCaseName)) {
                return m;
            }

            // Serach for partial (non ambiguos) name matches
            if (lcMonth.startsWith(m.shortestUniqueName)) {
                for (int i = 1; i <= lcMonth.length() && i <= m.lowerCaseName.length(); i++) {
                    var subStr = m.lowerCaseName.substring(0, i);
                    if (lcMonth.equals(subStr)) {
                        return m;
                    }
                }
            }

        }

        throw new IllegalArgumentException("No month uniquely idenifies the given String (" + month + ")");
    }
}
