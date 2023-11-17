package christmas.domain;

public enum Calendar {
    WEEKEND(1, 2, 8, 9, 15, 16, 22, 23, 29, 30),
    WEEKDAY(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31),
    SPECIAL_DAY(3, 10, 17, 24, 25, 31);

    private final int[] days;

    Calendar(int... days) {
        this.days = days;
    }

    public int[] getDays() {
        return days;
    }

    public static boolean isWeekday(int date) {
        for (Calendar calendar : values()) {
            for (int weekday : calendar.getDays()) {
                if (weekday == date && calendar == WEEKDAY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWeekend(int date) {
        for (Calendar calendar : values()) {
            for (int weekend : calendar.getDays()) {
                if (weekend == date && calendar == WEEKEND) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSpecialDay(int date) {
        for (Calendar calendar : values()) {
            for (int specialDay : calendar.getDays()) {
                if (specialDay == date && calendar == SPECIAL_DAY) {
                    return true;
                }
            }
        }
        return false;
    }
}
