package christmas.domain;

public enum EventBadge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타");

    private final int threshold;
    private final String description;

    EventBadge(int threshold, String description) {
        this.threshold = threshold;
        this.description = description;
    }

    public static EventBadge getBadge(int totalAfterBenefit) {
        for (EventBadge badge : values()) {
            if (totalAfterBenefit >= badge.threshold) {
                return badge;
            }
        }
        return EventBadge.SANTA;
    }

    public String getDescription() {
        return description;
    }
}
