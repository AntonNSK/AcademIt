package ru.academits.gusev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from1, double to1) {
        this.from = from1;
        this.to = to1;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    public double calculateLength() {
        return (to - from);
    }

    public boolean checkIntersection(Range variant) {
        if (from > variant.getTo() || to < variant.getFrom()) {
            return false;
        }
        return true;
    }

    public Range intersection(Range variant) {
        if (checkIntersection(variant)) {
            return new Range(Math.max(from, variant.getFrom()), Math.min(to, variant.getTo()));
        }
        return null;
    }

    public Range[] union(Range variant) {
        if (checkIntersection(variant)) {
            return new Range[]{new Range(Math.min(from, variant.getFrom()), Math.max(to, variant.getTo()))};
        }
        return new Range[]{new Range(Math.min(from, variant.getFrom()), Math.min(to, variant.getTo())), new Range(Math.max(from, variant.getFrom()), Math.max(to, variant.getTo()))};
    }

    public Range[] difference(Range variant) {
        if (checkIntersection(variant)) {
            if (!isInside(variant.getFrom()) && !isInside(variant.getTo())) {
                return new Range[0];
            }
            if (isInside(variant.getFrom()) && isInside(variant.getTo())) {
                return new Range[]{new Range(from, variant.getFrom()), new Range(variant.getTo(), to)};
            }
            if (isInside(variant.getFrom())) {
                return new Range[]{new Range(from, variant.getFrom())};
            }
            return new Range[]{new Range(variant.getTo(), to)};
        }
        return new Range[]{new Range(from, to)};
    }
}
