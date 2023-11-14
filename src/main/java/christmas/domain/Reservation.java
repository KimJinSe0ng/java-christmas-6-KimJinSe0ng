package christmas.domain;

import christmas.validator.Validator;

public class Reservation {
    private final int date;

    private Reservation(int date) {
        Validator.isInRange(date);
        this.date = date;
    }

    public static Reservation from(int date) {
        return new Reservation(date);
    }

    public int getDate() {
        return date;
    }
}
