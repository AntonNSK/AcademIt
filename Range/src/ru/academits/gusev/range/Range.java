package ru.academits.gusev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
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

    public boolean notIntersection(Range variant) {
        return (from > variant.getTo() || to < variant.getFrom());
    }

    public Range intersection(Range variant) {
        if (notIntersection(variant)) {
            return null;
        }
        return new Range(Math.max(from, variant.getFrom()), Math.min(to, variant.getTo()));
    }

    public Range[] union(Range variant) {
        if (notIntersection(variant)) {
            return new Range[]{new Range(Math.min(from, variant.getFrom()), Math.min(to, variant.getTo())), new Range(Math.max(from, variant.getFrom()), Math.max(to, variant.getTo()))};
        }
        return new Range[]{new Range(Math.min(from, variant.getFrom()), Math.max(to, variant.getTo()))};
    }

    public Range[] difference(Range variant) {
        if (notIntersection(variant)) {
            return new Range[]{new Range(from, to)};
        }
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
}
